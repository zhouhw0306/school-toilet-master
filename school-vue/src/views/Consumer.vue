<template>
  <div style="height: auto;display: flex;flex-wrap: wrap">
    <div class="tu">
      <div id="chart1" class="ech"></div>
    </div>
    <div class="tu">
      <div id="chart2" class="ech"></div>
    </div>
    <div class="tu">
      <div id="chart3" class="ech"></div>
    </div>
  </div>
</template>

<style>
.tu{
  width:600px;
  height:400px;
  margin:15px;
  background-color: #f8f7f5;
}
.ech{
  width:100%;height:400px
}

</style>

<script>
import {getDataByType} from "../api/index";
import {getDataByTu2} from "../api/index";
import {getDataByTu3} from "../api/index";

export default {
    name: 'tu1',
    data() {
        return {
            chart1:'',
            chart2:'',
            chart3:'',
            two:{},
            three:{}
        }
    },
    mounted() {
        this.init()
    },
    methods: {
        async init(){
            getDataByTu2().then(res=>{
              this.two = res.data
            }).catch(err=>{
              this.$message.error(err)
            })
            await getDataByTu3().then(res=>{
              this.three = res.data
            }).catch(err=>{
              this.$message.error(err)
            })
            getDataByType().then(res=>{
                this.drawLine(res)
            }).catch(err=>{
              this.$message.error(err);
            })
        },
        drawLine(c1data) {
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
                        data : c1data
                    }
                ]
            })
            this.chart2 = this.$echarts.init(document.getElementById('chart2'))
            this.chart2.setOption({
              title : {
                text :'坑位负载实况',
                subtext :'',
                x :'left'
              },
              series: [
                {
                  type: 'gauge',
                  startAngle: 90,
                  endAngle: -270,
                  pointer: {
                    show: false
                  },
                  progress: {
                    show: true,
                    overlap: false,
                    roundCap: true,
                    clip: false,
                    itemStyle: {
                      borderWidth: 1,
                      borderColor: '#464646'
                    }
                  },
                  axisLine: {
                    lineStyle: {
                      width: 30
                    }
                  },
                  splitLine: {
                    show: false,
                    distance: 0,
                    length: 10
                  },
                  axisTick: {
                    show: false
                  },
                  axisLabel: {
                    show: false,
                    distance: 50
                  },
                  data: [
                    {
                      value: this.two.a,
                      name: '小便池',
                      title: {
                        offsetCenter: ['0%', '-50%']
                      },
                      detail: {
                        valueAnimation: true,
                        offsetCenter: ['0%', '-30%']
                      }
                    },
                    {
                      value: this.two.b,
                      name: '蹲坑',
                      title: {
                        offsetCenter: ['0%', '-10%']
                      },
                      detail: {
                        valueAnimation: true,
                        offsetCenter: ['0%', '10%']
                      }
                    },
                    {
                      value: this.two.c,
                      name: '马桶',
                      title: {
                        offsetCenter: ['0%', '30%']
                      },
                      detail: {
                        valueAnimation: true,
                        offsetCenter: ['0%', '50%']
                      }
                    }
                  ],
                  title: {
                    fontSize: 14
                  },
                  detail: {
                    width: 50,
                    height: 14,
                    fontSize: 14,
                    color: 'auto',
                    borderColor: 'auto',
                    borderRadius: 20,
                    borderWidth: 1,
                    formatter: '{value}%'
                  }
                }
              ]
            })
            this.chart3 = this.$echarts.init(document.getElementById('chart3'))
            this.chart3.setOption({
              title : {
                text :'坑位分布情况',
                subtext :'',
                x :'left'
              },
              legend: {
                top: 'bottom'
              },
              toolbox: {
                show: true,
                feature: {
                  mark: { show: true },
                  dataView: { show: true, readOnly: false },
                  restore: { show: true },
                  saveAsImage: { show: true }
                }
              },
              series: [
                {
                  name: 'Nightingale Chart',
                  type: 'pie',
                  radius: [50, 160],
                  center: ['50%', '45%'],
                  roseType: 'area',
                  itemStyle: {
                    borderRadius: 15
                  },
                  data: [
                    { value: this.three[0].value, name: '启德楼' },
                    { value: this.three[1].value, name: '爱心楼' },
                    { value: this.three[2].value, name: '逸夫楼' },
                    { value: this.three[3].value, name: '致远楼' },
                    { value: this.three[4].value, name: '沁华楼' },
                  ]
                }
              ]
            })
        }
    }
}
</script>
