//radio选中改变颜色
function cColor() {
    var bgColor = "#fff";
    switch (this.className) {
        case "ck":
            bgColor = "#55ec55";
            break;
        case "nck":
            bgColor = "#f23232";
            break;
        case "no":
            bgColor = "#938f8f";
            break;
    }
    $(this).siblings().css("background", "#fff").css("color", "#000");
    $(this).css("background", bgColor).css("color", "#fff");
}

//按照公式计算得出正确与否-默认公式
function checkValue(prevValue, thisValue, point) {
    //console.log(arguments);
    var minus = Number(prevValue) - Number(thisValue);
    var mult = Number(prevValue) * Number(point);
    //console.log(minus +"----"+mult)
    if (Math.abs(minus) <= mult) {
        return true;
    }
    return false;
}

//判断是否前比后大
function mmCompere(prevValue, thisValue, point) {
    //console.log(arguments);
    return Math.abs(Number(prevValue) - Number(thisValue)) <= point;

}

//表格渲染与功能添加
function tableGet(elem, data,all) {
    function checkRadio(nub, num) {
        data[nub].check.on = num;
    }
    //以闭包的形式获取每一次循环的数值
    //遍历所有的数据
    for (var i = 0; i < data.length; i++) {
        (function (i) {
            var trs = $("<tr>"), tds = $("<td>"),
                tras = "<br />", s_i = i, tbody = $("<tbody>");
            if (data[i].fixed !== true) {
                var num = data[i].value.length;
                //遍历需要添加的行数
                for (var p = 0; p < data[i].value.length; p++) {
                    (function (p) {
                        var s_p = p;

                        //当输入完毕失去焦点时执行的函数
                        function blurFunc(f) {
                            //将输入的内容中非数字的部分剔除
                            var tttx = $(this).text();
                            $(this).text(tttx.replace(/[^0-9-.]+/, ''));
                            if (ttx !== $(this).text()) {
                                //console.log(f);
                                data[s_i].value[s_p].data[f] = $(this).text();
                                var end = null, sd = null;
                                //判断当前所在行数据中是否定义了计算公式，是的话使用计算公式，没有的话使用默认计算公式（|X-Y|<X*Z%）
                                if (data[s_i].check.fuc) {
                                    switch (data[s_i].check.fuc) {
                                        case "add3":
                                            end = add3Check(data[s_i].value[0].data[f], $(this).text(), "0.0" + data[s_i].check.num);
                                            break;
                                        case "maxmin":
                                            end = mmCompere(data[s_i].value[0].hideData, $(this).text(), data[s_i].check.num);
                                            break
                                    }
                                } else {
                                    end = checkValue(data[s_i].value[0].data[f], $(this).text(), "0.0" + data[s_i].check.num);
                                }
                                data[s_i].value[s_p].check[f] = end;
                                //如果当前是由check下控制则向check中写入
                                if (data[s_i].check.check) {
                                    data[s_i].check.check[s_p] = data[s_i].value[s_p].check[f];
                                }
                                //判断当前是否由value数据下控制
                                if (data[s_i].check.check) {
                                    sd = data[s_i].check.check
                                } else {
                                    sd = data[s_i].value[s_p].check
                                }
                                for (var i = 0; i < sd.length; i++) {
                                    var me = $(this).parent().prev().children("td"), nu = 0;
                                    //console.log(me);
                                    //判断当前数据是不是分段合并数据
                                    if (data[s_i].number) {
                                        nu = data[s_i].number;
                                    }
                                    //判断当前数据行内的是否又隐式计算数据
                                    if (data[s_i].value[s_p].hideData) {
                                        me = $(this).parent().children("td")
                                    }
                                    //当不适用未选中时渲染颜色
                                    if (!me.find("label[class='no']").find("input").attr("checked")) {
                                        me.find("label[class='nck']").eq(nu).siblings().css("background", "#fff").css("color", "#000");
                                        var mes = me.find("label[class='nck']").eq(nu);
                                            mes.css("color", "#fff");
                                        if(sd[i] === false) {
                                            mes.css("background", "#f23232");
                                            break;
                                        } else {
                                            mes.css("background", "#55ec55");
                                        }
                                    }
                                }
                            }
                        }

                        //创建标题行
                        if (data[i].value[p].main === true) {
                            var tf = false, clas = "";
                            //标题行是否可以编辑
                            if (data[i].value[p].edit === true) {
                                tf = true;
                                clas = "background: #fff;"
                            }
                            //动态创建标题行数据格
                            trs.append(
                                $("<td>").attr({
                                    "rowspan": num,
                                    "class": "am-text-middle t_title"
                                }).append(data[i].name.title + "<br />" + data[i].name.tip)
                            ).append(
                                $("<td>").attr({"class": "t_title", "style": clas}).append(data[i].value[0].title)
                            );
                            //创建动态数据格
                            for (var k = 0; k < data[i].value[0].data.length; k++) {
                                (function (k) {
                                    trs.append(
                                        $("<td>").attr({
                                            "style": clas,
                                            "contenteditable": tf
                                        }).append(data[i].value[0].data[k]).on('focus', function () {
                                            ttx = $(this).text();
                                        }).on('blur', function () {
                                            blurFunc.call($(this), k);
                                        })
                                    )
                                })(k)
                            }
                            tds.attr({
                                "rowspan": num,
                                "class": "am-text-middle td_end t_radio"
                            }).append(data[i].check.txt + tras)
                            //创建单选按钮
                            for (var j = 0; j < data[i].check.radio.length; j++) {
                                var ck = false;//
                                var dis = true;//禁止用户点击按钮
                                var rd = "radio";
                                if (data[i].check.on === j) {
                                    ck = true;
                                }
                                if (data[i].check.attr[j + 1] === "no") {
                                    dis = false;//不可点击 "不适用"
                                }
                                tds.append(
                                    $("<label>").attr("class", data[i].check.attr[j + 1]).append(
                                        $("<input>").attr({
                                            "type": rd,
                                            "name": data[i].check.attr[0],
                                            "checked": ck,
                                            "disabled": dis
                                        })
                                    ).append(
                                        $("<span>").append(data[i].check.radio[j])
                                    ).on('click', function () {
                                        //只有当当前radio可以选中时才会变色
                                        if (!$(this).find("input[type='radio']").attr("disabled")) {
                                            cColor.apply(this);
                                            switch (this.className) {
                                                case "ck":
                                                    data[s_i].check.on = 0;
                                                    break;
                                                case "nck":
                                                    data[s_i].check.on = 1;
                                                    break;
                                                case "no":
                                                    data[s_i].check.on = 2;
                                                    break;
                                            }
                                        }
                                    })
                                )
                            }
                            trs.append(tds)
                        } else {
                            //创建输入行
                            if (data[i].value[p].edit === true) {
                                trs = $("<tr>");
                                tds = $("<td>");
                                //输入行表头
                                trs.append(
                                    $("<td>").attr("class", "t_title").append(data[i].value[p].title)
                                );
                                //输入行内容块,f:块数
                                for (var f = 0; f < data[i].value[p].data.length; f++) {
                                    var ttx = "";
                                    (function (f) {
                                        trs.append(
                                            $("<td>").attr("contenteditable", "true").append(data[i].value[p].data[f]).on('focus', function () {
                                                ttx = $(this).text();
                                            }).on('blur', function () {
                                                blurFunc.call($(this), f);
                                            })
                                        );
                                    })(f)
                                }
                            }
                        }
                        if (data[i].fixed === false) {
                            tbody.append(trs);
                        } else if (typeof data[i].fixed === "number") {
                            var t_num = data[i].fixed;
                            $(elem + " tbody").eq(t_num).children("tr").eq(p).append(trs.children());
                        }
                    })(p)
                }
            } else {
                var ttrs = $("<tr>");
                var ttds = $("<td>");
                ttrs.append(
                    $("<td>").attr({"class": "am-text-middle t_title"}).append(data[i].name.title)
                )
                ttds.attr({"class": "am-text-middle td_end t_radio"})
                for (var j = 0; j < data[i].check.radio.length; j++) {
                    var ck = false;
                    if (data[i].check.on === j) {
                        ck = true;
                    }
                    ttds.attr("colspan", data[i].check.cols).append(
                        $("<label>").attr("class", data[i].check.attr[j + 1]).append(
                            $("<input>").attr({"type": "radio", "name": data[i].check.attr[0], "checked": ck})
                        ).append(
                            $("<span>").append(data[i].check.radio[j])
                        ).on('click', function () {
                            cColor.apply(this);
                            switch (this.className) {
                                case "ck":
                                    data[s_i].check.on = 0;
                                    break;
                                case "nck":
                                    data[s_i].check.on = 1;
                                    break;
                            }
                        })
                    )
                    ttrs.append(ttds);
                    if (!data[i].chain) {
                        tbody.append(ttrs);
                    } else {
                        var t_num = data[i].chain;
                        $(elem + " tbody").eq(t_num).children("tr").eq(0).append(ttrs.children());
                    }
                }
            }
            $(elem).append(tbody);
        })(i)
    }
    //console.log(data);
    $("#submit").on('click', function () {
        all.data.data = data;
        jQajax({action: "send", data: JSON.stringify(all)});
    });
}

//ajax数据获取
function jQajax(subData) {
    //使用外部函数形式获取异步数据
    var datas = function (callback) {
        $.ajax({
            url: "./data.php",
            method: "POST",
            data: subData,
            success: callback
        })
    }
    datas(function (data) {
        if (data.msg === "success") {
            if(data.data.mbId){
                tableGet("#table", JSON.parse(data.data.data),data);
            }else{
                alert("保存成功！");
            }
        }else{
            alert("数据保存失败，请重新提交！");
        }
    })
}
