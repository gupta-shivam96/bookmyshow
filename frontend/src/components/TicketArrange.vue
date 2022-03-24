<template>
<table cellspacing="0" cellpadding="0" class="setmain">
   <tbody>
      <tr>
         <td class="PriceB1" colspan="2">
            <div class="seatP">PREMIUM-Rs. 236.00</div>
            <div id="Clear_0000000002" class="canset" style="margin: 12px 12px 0 0; display:none;"><img src="//in.bmscdn.com/bmsin/SLIMG/1_4.gif?v1" style="margin-bottom:-4px;"><a href="javascript:;" onclick="fnClearSel('0000000002');" style="text-decoration:underline;">&nbsp;Clear Selaction</a></div>
            <div id="MultiErr_0000000002" class="canset" style="margin: 12px 12px 0 0; display:none;"><span> X </span> &nbsp; You can't select multiple sets categories </div>
         </td>
      </tr>
      <tr>
         <td>
            <div class="seatR Setrow1">A</div>
         </td>
         <td class="SRow1">
            <div class="seatI">&nbsp;</div>
            <div class="seatI"><a class="_blocked" href="javascript:;">1</a></div>
            <div class="seatI"><a class="_blocked" href="javascript:;">2</a></div>
            <div class="seatI"><a class="_blocked" href="javascript:;">3</a></div>
            <div class="seatI"><a class="_blocked" href="javascript:;">4</a></div>
            <div class="seatI"><a class="_blocked" href="javascript:;">5</a></div>
         </td>
      </tr>
      <tr>
         <td class="PriceB1" colspan="2">
            <div class="seatP">CLASSIC-Rs. 236.00</div>
            <div id="Clear_0000000002" class="canset" style="margin: 12px 12px 0 0; display:none;"><img src="//in.bmscdn.com/bmsin/SLIMG/1_4.gif?v1" style="margin-bottom:-4px;"><a href="javascript:;" onclick="fnClearSel('0000000002');" style="text-decoration:underline;">&nbsp;Clear Selaction</a></div>
            <div id="MultiErr_0000000002" class="canset" style="margin: 12px 12px 0 0; display:none;"><span> X </span> &nbsp; You can't select multiple sets categories </div>
         </td>
      </tr>
      <tr>
         <td>
            <div class="seatR Setrow1">B</div>
         </td>
         <td class="SRow1">
            <div class="seatI">&nbsp;</div>
            <div class="seatI"><a class="_blocked" href="javascript:;">1</a></div>
            <div class="seatI"><a class="_blocked" href="javascript:;">2</a></div>
            <div class="seatI"><a class="_blocked" href="javascript:;">3</a></div>
            <div class="seatI"><a class="_blocked" href="javascript:;">4</a></div>
            <div class="seatI"><a class="_blocked" href="javascript:;">5</a></div>
         </td>
      </tr>
   </tbody>
</table>
</template>

<script>


// import CaRousel from './../components/carousel/CarouselName.vue'
export default {
    name: 'TicketArrange',
    data () {
        return {
           maxSeat : 21,
           seatPerRow : 5
        }
    },
    methods : {
        getAllTicketSeats() {
            var premiumSeatCount = Math.ceil(this.maxSeat/2)
            var classicSeatCount = this.maxSeat - premiumSeatCount
            console.log("Premium Seats : " + premiumSeatCount + " || Classic Seats : " + classicSeatCount);
            var premiumSeats = new Array();
            var classicSeats = new Array();

            for (var i = 1; i < premiumSeatCount+1; i++) {
                premiumSeats.push(i);
            }
            for (var j = premiumSeatCount+1; j < classicSeatCount+premiumSeatCount+1; j++) {
                classicSeats.push(j);
            }

            console.log("Premium Seats = " + premiumSeats)
            console.log("Classic Seats = " + classicSeats)
            const chunk = (arr, size) => arr.reduce((acc, e, i) => (i % size ? acc[acc.length - 1].push(e) : acc.push([e]), acc), []);
            const premiumPerSeatValues = chunk(premiumSeats, this.seatPerRow);
            console.log("Premium Seat per row = " + premiumPerSeatValues)
            const classicPerSeatValues = chunk(classicSeats, this.seatPerRow);
            console.log("Premium Seat per row = " + classicPerSeatValues)

            const values = chunk([1, 2, 3, 4, 5, 6, 7, 8], 3); 
            console.log(values);


            const test =Array.from({length: 10}, (v, k) => k+1);
            console.log(test)
        }
    },
    beforeMount(){
        this.getAllTicketSeats();
    }
  
};


</script>

<style>
.__seat-action {
    background: #fff;
    padding: 10px;
    text-align: center;
    box-shadow: 0 0 10px 0 rgb(0 0 0 / 50%);
    position: fixed;
    bottom: 0;
    left: 0;
    width: 100%;
    z-index: 99;
}
.bar-btn._small {
    width: 30%;
        margin: auto;
}
.bar-btn._primary {
    background: #f84464;
    color: #fff;
}
.__seat-action {
    background: #fff;
    padding: 10px;
    text-align: center;
    box-shadow: 0 0 10px 0 rgb(0 0 0 / 50%);
    position: fixed;
    bottom: 0;
    left: 0;
    width: 100%;
    z-index: 99;
}
.bar-btn {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 49%;
    height: 100%;
    box-shadow: 0 1px 8px rgb(0 0 0 / 16%);
    border-radius: 8px;
    cursor: pointer;
    min-height: 40px;
}
.container._seat {
    overflow-y: auto;
}
.bkf-layout .bkf-container {
    width: 100%;
    zoom: 1;
    display: none;
    position: relative;
    height: 100%;
}
.__double-booking {
    display: block;
    margin-bottom: 10px;
    color: #c02c39;
    font-size: 14px;
    text-align: center;
    margin-top: 20px;
}
.seat-container {
    display: block;
    width: 100%;
    margin: 0 auto;
    background: #fafafa;
    overflow-y: auto;
}
.rem-seats {
    text-align: center;
    margin: 12px auto;
    display: none;
}
.popular-seat-msg-box {
    position: absolute;
    right: 20px;
    top: 20px;
    cursor: pointer;
    display: none;
}
 .info-icon {
    position: relative;
    width: 16px;
    height: 16px;
    margin-left: 5px;
    display: inline-block;
}
.pop-tool-tip {
    width: 200px;
    right: -8px;
    font-size: .8em;
    text-align: center;
    position: absolute;
    cursor: default;
    border: 1px solid;
    color: #fff;
    background: rgba(0,0,0,.6);
    border-radius: 2px;
    margin-top: 5px;
    padding: 10px;
    display: none;
}
.seats {
    width: 100%;
    position: relative;
    z-index: 1;
    zoom: 1;
    padding: 50px 30px;
    background: #fafafa;
}
.__block {
    padding-bottom: 20px;
    width: 100%;
}
table {
    z-index: 1;
    width: 100%;
}
.status-9 {
    display:none;
}
.seatI a:hover{
    background-color: #1ea83c;
}
._available:hover {
    background-color: #1ea83c;
}
.seatP {
    width: 100%;
    color: #999;
    font-size: 12px;
    margin-bottom: 5px;
    text-align: left;
    padding-bottom: 10px;
    border-bottom: 1px solid #ececec;
}
.seat-social-distancing {
    width: 16px;
    height: 16px;
}
.seatI a {
    display: inline-block;
    font-size: 10px;
    line-height: 25px;
    font-weight: 400;
    background: #fff;
    vertical-align: top;
}
.seats .__block>div table .seatI a {
    display: inline-block;
    font-size: 10px;
    line-height: 25px;
    font-weight: 400;
    background: #fff;
    vertical-align: top;
}
 a._selected {
    color: #fff;
    background-color: #1ea83c!important;
    border-color: #1ea83c;
}
 a._available {
    border: 1px solid #1ea83c;
}
table a {
    display: inline-block;
    width: 25px;
    height: 25px;
    border-radius: 2px;
    color: #1ea83c;
    text-align: center;
    font-size: 10px;
}
.seatI {
    margin: 4px;
    float: left;
    width: 25px;
    height: 25px;
}
.seat-svg-container {
    display: flex;
    height: 25px;
    width: 25px;
    overflow: hidden;
    justify-content: center;
    align-items: center;
} .PriceB1 {
    position: relative;
    z-index: 1;
}
</style>