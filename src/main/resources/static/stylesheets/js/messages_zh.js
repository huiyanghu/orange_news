/*
* Translated default messages for the jQuery validation plugin.
* Locale: ZH (Chinese, 中文 (Zhōngwén), 汉语, 漢語)
*/
$.extend($.validator.messages, {
required: "<code>必须填写</code>",
remote: "<code>请修正此栏位</code>",
email: "<code>请输入有效的电子邮件</code>",
url: "<code>请输入有效的网址</code>",
date: "<code>请输入有效的日期</code>",
dateISO: "<code>请输入有效的日期 (YYYY-MM-DD)</code>",
number: "<code>请输入正确的数字</code>",
digits: "<code>只可输入数字</code>",
creditcard: "<code>请输入有效的信用卡号码</code>",
equalTo: "<code>你的输入不相同</code>",
extension: "<code>请输入有效的后缀</code>",
maxlength: "<code>"+$.validator.format("最多 {0} 个字")+"</code>",
minlength: "<code>"+$.validator.format("最少 {0} 个字")+"</code>",
rangelength: "<code>"+$.validator.format("请输入长度为 {0} 至 {1} 之間的字串")+"</code>",
range:"<code>"+ $.validator.format("请输入 {0} 至 {1} 之间的数值")+"</code>",
max:"<code>"+ $.validator.format("请输入不大于 {0} 的数值")+"</code>",
min: "<code>"+$.validator.format("请输入不小于 {0} 的数值")+"</code>"
});