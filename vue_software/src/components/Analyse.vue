<template>
    <div class="part">
        <div class="box1" ref="box1" >
            <div v-if="isQuestionNull">
                <span>该学生还未有错题记录。</span>
            </div>
        </div>
        <div class="box2" ref="box2" float="left">
            <div v-if="isScoreNull">
                <span>该学生还未有成绩记录。</span>
            </div>
        </div>
  </div>
</template>

<script>
export default {
    data(){
        return{
            isQuestionNull:false,
            isScoreNull:false,
            //id从用户信息里取出来,这里还没设计用户信息的取值因此先设置为3
            id: 3,
        }
    },
    created(){
    },
    mounted(){
        this.getAnalyseInfoPie();
        this.getScoreInfoLine();
    },
    methods:{
        async getAnalyseInfoPie(){
            //const id = winodw.session.getItem("user").id;
            await this.$http.get("/getAnalyseInformation/"+this.id)
            .then((result) => {
                let analyseInfo = result.data.analyseInfo;
                if(analyseInfo.length > 0){
                    var charts = this.$echarts.init(this.$refs.box1);
                    var option1 = {
                        title: {
                            text: '错题分析图表',
                            x:'center'
                        },
                        tooltip: {
                            trigger: 'item',
                            //系列名称、数据项名称、数值、百分比
                            formatter: "{a}：{b} <br/> {c}道 ({d}%)"
                        },
                        legend: {
                            orient: 'vertical',
                            right: 'right',
                            data:[]
                        },
                        series: [{
                            name: '错题类型',
                            type: 'pie',
                            radius : '50%',
                            center: ['50%', '35%'],
                            data:[],
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }]

                    };
                    analyseInfo.forEach(item =>{
                        let data = {value:item.number, name:item.kind};
                        option1.series[0].data.push(data);
                        option1.legend.data.push(item.kind);
                    })
                    charts.setOption(option1);
                }
                else{
                    this.isQuestionNull = true;
                }
            })
        },
        async getScoreInfoLine(){
            this.$http.get("/getScoreInformation/"+this.id)
            .then((result) =>{
                console.log(result);
                let scoreInfo = result.data.ScoreInfo;
                if(scoreInfo.length > 0){
                    var lineCharts = this.$echarts.init(this.$refs.box2);
                    var option2 = {
                        title: {
                            text: '成绩分析图表',
                            x:'center'
                        },
                        xAxis: {
                            type: "category",
                            data: []
                        },
                        yAxis:{
                            type: "value"
                        },
                        series: [{
                            name: '错题类型',
                            type: 'line',
                            data:[],
                            itemStyle: { normal: { label: { show: true } } }
                        }]

                    };
                    scoreInfo.forEach(item =>{
                        let data = {value:item.score, name:item.kind};
                        option2.series[0].data.push(data);
                        option2.xAxis.data.push(item.kind);
                    })
                    lineCharts.setOption(option2);
                }
                else{
                    this.isQuestionNull = true;
                }
            })
        }
    }
}
</script>

<style lang="less" scoped>
.part{
    width: 100%;
    height: 100%;
    display: flex;
    .box1{
        float: left;
        width: 600px;
        height: 600px;
        margin-left: 40px;
        top: 20%;
    }
    .box2{
        float: left;
        width: 600px;
        height: 600px;
        margin-left: 100px;
        margin-top: 5%;
    }
}

</style>
