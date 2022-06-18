// 加载地图
var map = new AMap.Map('myMap', {
    zoom: 10,//级别
    center: [114.071471,22.715473],//中心点坐标
    viewMode: '2D'//使用3D视图
});
// 设置地图样式
map.setMapStyle('amap://styles/darkblue');

// ------------------------------------------------------------------------------------------------------
// 垃圾站点信息
(function () {
    // TODO:后端垃圾站点数据
    $.get('json/garbage_station.json', function (garbage_station) {
        // 将创建的点标记添加到已有的地图实例：
        var maker;
        var path = [];
        for (var i = 0; i < garbage_station.length; i += 1) {
            var marker = new AMap.Marker({
                position: [garbage_station[i].position[0], garbage_station[i].position[1]],   // 经纬度对象，也可以是经纬度构成的一维数组[116.39, 39.9]
                icon: new AMap.Icon({
                    image: 'images/garbage_station.png',
                    size: new AMap.Size(40, 40),  //图标所处区域大小
                    imageSize: new AMap.Size(40, 40) //图标大小
                }),
                offset: new AMap.Pixel(20, -40),
            });

            // 信息窗体
            marker.content = '<p>站点编号：<span>' + garbage_station[i].code + '</span></p>' +
                '<p>站点名称：<span>' + garbage_station[i].name + '</span></p>' +
                '<p>垃圾余率：<span>' + garbage_station[i].used + '%</span></p>'+
                '<button onclick="scheduling('+marker.getPosition().lng+','+marker.getPosition().lat+');"><a>召唤运输车辆</a></button>';
            marker.on('click', markerClick);
            // console.log(marker.getPosition());

            map.add(marker);
        }

        // 无参数，默认包括所有覆盖物的情况
        map.setFitView();

        //创建信息窗体
        var infoWindow = new AMap.InfoWindow({
            anchor: 'bottom-center',
            offset: new AMap.Pixel(45, -35)
        });
        // 垃圾站点信息窗体点击事件
        function markerClick(e) {
            // 添加内容
            infoWindow.setContent('<h4>垃圾站点信息</h4>' + e.target.content);
            //打开信息窗体
            infoWindow.open(map, e.target.getPosition());
        }

        // 关闭信息窗体事件
        map.on('click', function () {
            infoWindow.close();
        });
    })
})();

// ------------------------------------------------------------------------------------------------------


// ------------------------------------------------------------------------------------------------------
// 垃圾运输车信息
(function () {
    // TODO:后端垃圾运输车辆信息
    $.get('json/garbage_car.json', function (garbage_car) {
        cars_pic = ['images/garbage_car.png', 'images/garbage_car_right.png'];
        // 将创建的点标记添加到已有的地图实例：
        var maker;
        var path = [];
        for (var i = 0; i < garbage_car.length; i += 1) {
            var marker = new AMap.Marker({
                position: [garbage_car[i].position[0], garbage_car[i].position[1]],   // 经纬度对象，也可以是经纬度构成的一维数组[116.39, 39.9]
                icon: new AMap.Icon({
                    image: cars_pic[i % 2],
                    size: new AMap.Size(30, 30),  //图标所处区域大小
                    imageSize: new AMap.Size(30, 30) //图标大小
                }),
            });

            // 信息窗体
            marker.content = '<p>车辆编号：<span>' + garbage_car[i].code + '<span></p>' +
                '<p>车辆名称：<span>' + garbage_car[i].name + '<span></p>' +
                '<p>车装载率：<span>' + garbage_car[i].used + '%<span></p>';
            marker.on('click', markerClick);

            map.add(marker);
        }

        // 无参数，默认包括所有覆盖物的情况
        map.setFitView();

        //创建信息窗体
        var infoWindow = new AMap.InfoWindow({
            anchor: 'bottom-center',
            offset: new AMap.Pixel(45, -35)
        });
        // 垃圾站点信息窗体点击事件
        function markerClick(e) {
            // 添加内容
            infoWindow.setContent('<h4>垃圾运输车辆信息</h4>' + e.target.content);
            //打开信息窗体
            infoWindow.open(map, e.target.getPosition());
        }
        // 关闭信息窗体事件
        map.on("click", function () {
            infoWindow.close();
        });
    })
})();

// ------------------------------------------------------------------------------------------------------


// ------------------------------------------------------------------------------------------------------
// 选择待处理运输的站点
// 当前待处理运输的垃圾站点(例如：第三教学楼)
// (function(){
//     var station_position = [114.069999,22.7205];
//     scheduling(station_position);
// })();

// 车辆调度
function scheduling(x,y) {
    console.log(x,y)
    $.get(['json/garbage_car.json'], function (info) {
        var station_position = [x,y];
        // 当前可调度的所有车辆
        var cars = info;

        // 遍历工具
        var min_distance = -1;
        // 格式：var choose_car={"name":"0000","position":[1,1]};
        // 确定调度的车辆
        var choose_car;

        // 获取最近空余车辆信息
        for (var i = 0; i < cars.length; i++) {
            var p1 = cars[i].position;
            var p2 = station_position;
            var dis = AMap.GeometryUtil.distance(p1, p2);
            if (min_distance < 0 || dis < min_distance) {
                min_distance = dis;
                choose_car = { "name": cars[i].name, "position": p1 };
            }
        }
        // 被选中的车辆信息
        console.log(choose_car);
        // 绘制路线
        create_route(choose_car.position,station_position);
    });
}

// 路径规划及绘制

// 解析DrivingRoute对象，构造成AMap.Polyline的path参数需要的格式
// DrivingResult对象结构参考文档 https://lbs.amap.com/api/javascript-api/reference/route-search#m_DriveRoute
function parseRouteToPath(route) {
    var path = []

    for (var i = 0, l = route.steps.length; i < l; i++) {
        var step = route.steps[i]

        for (var j = 0, n = step.path.length; j < n; j++) {
          path.push(step.path[j])
        }
    }

    return path
}
// 绘制路线
function drawRoute (route) {
    var path = parseRouteToPath(route)

    var startMarker = new AMap.Marker({
        position: path[0],
        icon: 'https://webapi.amap.com/theme/v1.3/markers/n/start.png',
        map: map
    })

    var endMarker = new AMap.Marker({
        position: path[path.length - 1],
        icon: 'https://webapi.amap.com/theme/v1.3/markers/n/end.png',
        map: map
    })

    var routeLine = new AMap.Polyline({
        path: path,
        isOutline: true,
        outlineColor: '#ffeeee',
        borderWeight: 2,
        strokeWeight: 5,
        strokeColor: '#0091ff',
        lineJoin: 'round'
    })

    map.add(routeLine);

    // 调整视野达到最佳显示区域
    map.setFitView([ startMarker, endMarker, routeLine ])

    map.on("click",function(){
        map.remove([routeLine,startMarker,endMarker]);
    });
}
// 调用程序
function create_route(p1,p2){  
    var drivingOption = {
        policy: AMap.DrivingPolicy.LEAST_DISTANCE, // 其它policy参数请参考 https://lbs.amap.com/api/javascript-api/reference/route-search#m_DrivingPolicy
    }
    
    // 构造路线导航类
    var driving = new AMap.Driving(drivingOption)
    
    // 根据起终点经纬度规划驾车导航路线
    driving.search(new AMap.LngLat(p1[0],p1[1]), new AMap.LngLat(p2[0], p2[1]), function(status, result) {
        // result即是对应的驾车导航信息，相关数据结构文档请参考 https://lbs.amap.com/api/javascript-api/reference/route-search#m_DrivingResult
        if (status === 'complete') {
            if (result.routes && result.routes.length) {
                // 绘制第一条路线，也可以按需求绘制其它几条路线
                drawRoute(result.routes[0])
                console.log('绘制驾车路线完成')
            }
        } else {
            console.log('获取驾车数据失败：' + result)
        }
    });
}


// ------------------------------------------------------------------------------------------------------

// 右键菜单
(function () {
    //创建右键菜单
    var contextMenu = new AMap.ContextMenu();

    //右键放大
    contextMenu.addItem("放大一级", function () {
        map.zoomIn();
    }, 0);

    //右键缩小
    contextMenu.addItem("缩小一级", function () {
        map.zoomOut();
    }, 1);

    //右键添加Marker标记
    contextMenu.addItem("添加标记", function (e) {
        var marker = new AMap.Marker({
            map: map,
            position: contextMenuPositon //基点位置
        });
    }, 3);

    //地图绑定鼠标右击事件——弹出右键菜单
    map.on('rightclick', function (e) {
        contextMenu.open(map, e.lnglat);
        contextMenuPositon = e.lnglat;
    });

    contextMenu.open(map, lnglat);
})();


