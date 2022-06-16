// 空白template
Vue.component('blank', {
    //此处编译器检查异常，以字符串形式，不用管
    template: `
                        <div class="row" style="padding-top:0.0mm; padding-bottom:0.0mm;">
                            <table>
                                <tbody>
                                <tr>
                                    <td class="cell border_box"
                                        style="width: auto; background-color: transparent; text-align: left; vertical-align: top; border-top: 0.75pt none #999999; border-right: 0.75pt none #999999; border-bottom: 0.75pt none #999999; border-left: 0.75pt none #999999;">
                                        <input type="hidden" name="key" value="">
                                        <pre style="min-height: 1pt; margin: 6.0mm 1.5mm 0.0mm 1.5mm;"><span class="SimSun"
                                                                                                             style="font-size: 1pt; color: #444444; background-color: transparent; font-weight: normal; font-style: normal; text-decoration: none; line-height: 1.0;"></span></pre>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
`
});

//标题template
Vue.component('head_title', {
    props: ["title"],
    template: `
          <div class="row" style="padding-top:0.0mm; padding-bottom:0.0mm;">
          <table>
            <tbody>
            <tr>
              <td class="cell border_box"
                  style="width: 16.0%; background-color: #000000; text-align: left; vertical-align: bottom; border-top: 0.75pt none #999999; border-right: 0.75pt none #999999; border-bottom: 0.75pt none #999999; border-left: 0.75pt none #999999;">
                <input type="hidden" name="key" value="title">
                <pre style="min-height: 11pt; margin: 1.5mm 3.0mm 0.5mm 1.5mm;"><span class="Arial"
                                                                                      style="font-size: 11pt; color: #ffffff; background-color: black; font-weight: bold; font-style: normal; text-decoration: none; line-height: 1.15;">{{ title }}</span></pre>
              </td>
              <td class="cell border_box"
                  style="width: auto; background-color: #ffffff; text-align: left; vertical-align: bottom; border-top: 0.75pt none #000000; border-right: 0.75pt none #000000; border-bottom: 0.75pt solid #000000; border-left: 0.75pt none #000000;">
                <input type="hidden" name="key" value="">
                <pre style="min-height: 11pt; margin: 1.5mm 3.0mm 0.5mm 1.5mm;"><span class="Arial"
                                                                                      style="font-size: 11pt; color: #000000; background-color: transparent; font-weight: bold; font-style: normal; text-decoration: none; line-height: 1.15;"></span></pre>
              </td>
            </tr>
            </tbody>
          </table>
          </div>
        `
});

//右边横框：附属于左边类别
Vue.component('description', {
    props: ["content"],
    template: `
          <div class="row" style="padding-top:0.0mm; padding-bottom:0.0mm;">
          <table>
            <tbody>
            <tr>
              <td class="cell border_box"
                  style="width: 16.0%; background-color: transparent; text-align: left; vertical-align: top; border-top: 0.75pt none #000000; border-right: 0.75pt solid #000000; border-bottom: 0.75pt none #000000; border-left: 0.75pt none #000000;">
                <input type="hidden" name="key" value="">
                <pre style="min-height: 10pt; margin: 1.0mm 0.5mm 1.0mm 1.5mm;"><span
                    class="Tahoma"
                    style="font-size: 10pt; color: #000000; background-color: transparent; font-weight: normal; font-style: normal; text-decoration: none; line-height: 1.15;"></span></pre>
              </td>
              <td class="cell border_box"
                  style="width: auto; background-color: transparent; text-align: left; vertical-align: middle; border-top: 0.75pt none #000000; border-right: 0.75pt none #000000; border-bottom: 0.75pt solid #000000; border-left: 0.75pt none #000000;">
                <input type="hidden" name="key" value="course">
                <pre style="min-height: 10pt; margin: 1.0mm 1.5mm 1.0mm 1.5mm;"><span
                    class="Tahoma"
                    style="font-size: 10pt; color: #000000; background-color: transparent; font-weight: normal; font-style: normal; text-decoration: none; line-height: 1.15;">{{ content }}</span></pre>
              </td>
            </tr>
            </tbody>
          </table>
          </div>
        `
});

//右边横框：底部--附属于左边的类别
Vue.component("description_bottom", {
    props: ["content"],
    template: `
          <div class="row" style="padding-top:0.0mm; padding-bottom:0.0mm;">
          <table>
            <tbody>
            <tr>
              <td class="cell border_box"
                  style="width: 16.0%; background-color: transparent; text-align: left; vertical-align: top; border-top: 0.75pt none #000000; border-right: 0.75pt solid #000000; border-bottom: 0.75pt solid #000000; border-left: 0.75pt none #000000;">
                <input type="hidden" name="key" value="">
                <pre style="min-height: 10pt; margin: 1.0mm 0.5mm 1.0mm 1.5mm;"><span
                    class="Tahoma"
                    style="font-size: 10pt; color: #000000; background-color: transparent; font-weight: normal; font-style: normal; text-decoration: none; line-height: 1.15;"></span></pre>
              </td>
              <td class="cell border_box"
                  style="width: auto; background-color: transparent; text-align: left; vertical-align: middle; border-top: 0.75pt none #000000; border-right: 0.75pt none #000000; border-bottom: 0.75pt solid #000000; border-left: 0.75pt none #000000;">
                <input type="hidden" name="key" value="scholarship">
                <pre style="min-height: 10pt; margin: 1.0mm 1.5mm 1.0mm 1.5mm;"><span
                    class="Tahoma"
                    style="font-size: 10pt; color: #000000; background-color: transparent; font-weight: normal; font-style: normal; text-decoration: none; line-height: 1.15;">{{ content }}</span></pre>
              </td>
            </tr>
            </tbody>
          </table>
          </div>`
})

//右边横框：单个--附属于左边的类别，并与类别同行
Vue.component("description_single", {
    props: ["title", "content"],
    template: `
          <div class="row" style="padding-top:0.0mm; padding-bottom:0.0mm;">
          <table>
            <tbody>
            <tr>
              <td class="cell border_box"
                  style="width: 16.0%; background-color: transparent; text-align: left; vertical-align: top; border-top: 0.75pt solid #000000; border-right: 0.75pt solid #000000; border-bottom: 0.75pt solid #000000; border-left: 0.75pt none #000000;">
                <input type="hidden" name="key" value="label">
                <pre style="min-height: 10pt; margin: 1.0mm 0.5mm 1.0mm 1.5mm;"><span
                    class="Arial"
                    style="font-size: 10pt; color: #000000; background-color: transparent; font-weight: bold; font-style: normal; text-decoration: none; line-height: 1.15;">{{ title }}</span></pre>
              </td>
              <td class="cell border_box"
                  style="width: auto; background-color: transparent; text-align: left; vertical-align: top; border-top: 0.75pt none #000000; border-right: 0.75pt none #000000; border-bottom: 0.75pt solid #000000; border-left: 0.75pt none #000000;">
                <input type="hidden" name="key" value="content">
                <pre style="min-height: 10pt; margin: 1.0mm 0.5mm 1.0mm 1.5mm;"><span
                    class="Arial"
                    style="font-size: 10pt; color: #000000; background-color: transparent; font-weight: normal; font-style: normal; text-decoration: none; line-height: 1.15;">{{ content }}</span></pre>
              </td>
            </tr>
            </tbody>
          </table>
          </div>
        `
});
//右边横框：多个-首个-附属于左边的类别，与类别同行
Vue.component("description_multiple_top", {
    props: ["title", "content"],
    template: `
          <div class="row" style="padding-top:0.0mm; padding-bottom:0.0mm;">
          <table>
            <tbody>
            <tr>
              <td class="cell border_box"
                  style="width: 16.0%; background-color: transparent; text-align: left; vertical-align: top; border-top: 0.75pt none #000000; border-right: 0.75pt solid #000000; border-bottom: 0.75pt none #000000; border-left: 0.75pt none #000000;">
                <input type="hidden" name="key" value="label">
                <pre style="min-height: 10pt; margin: 1.0mm 0.5mm 1.0mm 1.5mm;"><span
                    class="Arial"
                    style="font-size: 10pt; color: #000000; background-color: transparent; font-weight: bold; font-style: normal; text-decoration: none; line-height: 1.15;">{{ title }}</span></pre>
              </td>
              <td class="cell border_box"
                  style="width: auto; background-color: transparent; text-align: left; vertical-align: top; border-top: 0.75pt none #000000; border-right: 0.75pt none #000000; border-bottom: 0.75pt solid #000000; border-left: 0.75pt none #000000;">
                <input type="hidden" name="key" value="content">
                <pre style="min-height: 10pt; margin: 1.0mm 0.5mm 1.0mm 1.5mm;"><span
                    class="Arial"
                    style="font-size: 10pt; color: #000000; background-color: transparent; font-weight: normal; font-style: normal; text-decoration: none; line-height: 1.15;">{{ content }}</span></pre>
              </td>
            </tr>
            </tbody>
          </table>
          </div>
        `
});
