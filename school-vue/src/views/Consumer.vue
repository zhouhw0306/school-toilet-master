<template>
    <div class="tu1" style="width:600px;height:400px;background-color:#FEF8EF">
        <div id="chart1" style="width:100%;height:270px;float:left"></div>
    </div>
    
</template>

<script>
import {getDatabytype} from "../api/index";

export default {
    name: 'tu1',
    data() {
        return {
            formLabelWidth:'',
            chart1:'',
            //optionData1:[{"name":"小便池","value":20,"itemStyle":"red"},{"name":"蹲坑","value":20,"itemStyle":"#1FC48D"},{"name":"马桶","value":30,"itemStyle":"#6DC8EC"}]
        }
    },    
    mounted() {
        //this.drawLine()
    },
    created() {
        this.init()
    },
    methods: {
        init(){
            getDatabytype().then((res)=>{
                this.drawLine(res)
            }).catch((err)=>{this.$message.error("加载失败");})
        },
        drawLine(chdata) {
            this.chart1 = this.$echarts.init(document.getElementById('chart1'))
            this.chart1.setOption({
                title : {
                    text :'坑位类型统计',
                    subtext :'',
                    x :'left'
                },
                grid : {containLabel:true},
                tooltip : {
                    trigger : 'item',
                    formatter: '{a} <br/>{b} : {d}%'
                },
                color : ['red','#1FC48D','#6DC8EC'],
                legend : {
                    orient : 'vertical',
                    icon : 'circle',
                    align : 'left',
                    x : 'right',
                    y : 'bottom',
                    data : ["小便池","蹲坑","马桶"]
                },
                series : [
                    {
                        name : '类型',
                        type : 'pie',
                        radius : ['50%', '70%'],
                        avoidLabelOverlap : false,
                        center : ['40%', '50%'],
                        itemStyle : {
                            emphasis : {
                                shadowBlur : 10,
                                shadowOffsetX : 0,
                                shadowColor : 'rgba(0,0,0,0.5)'
                            },
                            color : function(params){
                                var colorList = ['red','#1FC48D','#6DC8EC']
                                return colorList[params.dataIndex]
                            }
                        },
                        data : chdata
                    }
                ]
            })
        }
    }
}
</script>