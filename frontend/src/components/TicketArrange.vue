<template>
    <!-- Premium Seats-->
    <div class="card">
        <div class="card-body">
            <div class="card-header">
              <div class="heading-color fs-title-color">PREMIUM-Rs. {{premiumSeatPrice}}</div>
            </div>
            <div class="table-responsive">
                <table class="table cursor">
                    <tbody>
                        <tr v-for="premiumSeat in premiumPerSeatValues" v-bind:key="premiumSeat">
                            <td v-for="premium in premiumSeat" v-bind:key="premium">
                                <input type="checkbox" :disabled = "!showAvailibility.showAvailable || showAvailibility.premiumBookedSeats.includes('P'+premium)"  class="custom-control-input " :id="premium" @change="addSeat(premium,'PREMIUM') ">
                                <label class="custom-control-label toggle-on-off cursor" :for="premium">{{premium}}</label>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- Classic Seats-->
    <div class="card">
        <div class="card-body">
            <div class="card-header">
              <div class="heading-color fs-title-color">CLASSIC-Rs. {{classicSeatPrice}}</div>
            </div>
            <div class="table-responsive">
                <table class="table cursor">
                    <tbody>
                        <tr v-for="classicSeat in classicPerSeatValues" v-bind:key="classicSeat">
                            <td v-for="classic in classicSeat" v-bind:key="classic">
                                <input type="checkbox" :disabled = "!showAvailibility.showAvailable || showAvailibility.classicBookedSeats.includes('C'+classic)" class="custom-control-input " :id="classic" @change="addSeat(classic,'CLASSIC')">
                                <label class="custom-control-label toggle-on-off cursor" :for="classic">{{classic}}</label> 
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="header-margin">
            <div class="btn btn-info" @click="createTicket()">Book Ticket</div>
        </div>
    </div>
</template>

<script>


// import CaRousel from './../components/carousel/CarouselName.vue'
import axios from 'axios'
export default {
    name: 'TicketArrange',
    data () {
        return {
            ticket : {
                movieName : this.$route.query.movie,
                theaterName : this.$route.query.theater,
                date : parseInt(this.$route.query.showDate),
                month : parseInt(this.$route.query.showMonth),
                year : parseInt(this.$route.query.showYear),
                hour : parseInt(this.$route.query.showTime.split(":",2)[0]),
                minute : parseInt(this.$route.query.showTime.split(":",2)[1]),
                premiumBookedSeats : [],
                classicBookedSeats : []
                
            },
            showAvailibility : null,
            maxSeat : this.$route.query.maxSeat,
            premiumSeatPrice : this.$route.query.premiumSeatPrice,
            classicSeatPrice : this.$route.query.classicSeatPrice,
            seatPerRow : 10,
            premiumPerSeatValues : [],
            classicPerSeatValues : []
        }
    },
    methods : {
        getAllTicketSeats() {
            console.log("  Movie : " + this.ticket.movieName + "  Theater : " + this.ticket.theaterName)
            console.log(this.ticket.date)
            console.log(this.ticket.month)
            console.log(this.ticket.year)
            console.log(this.ticket.hour)
            console.log(this.ticket.minute)
            var premiumSeatCount = Math.ceil(this.maxSeat/2)
            var classicSeatCount = this.maxSeat - premiumSeatCount
            console.log("Premium Seats : " + premiumSeatCount + " || Classic Seats : " + classicSeatCount);
            var premiumSeats = [];
            var classicSeats = [];

            for (let i = 1; i < premiumSeatCount+1; i++) {
                premiumSeats.push(i);
            }
            for (let i = premiumSeatCount+1; i < classicSeatCount+premiumSeatCount+1; i++) {
                classicSeats.push(i);
            }
            //Converting array into sub array
            const chunk = (arr, size) => arr.reduce((acc, e, i) => (i % size ? acc[acc.length - 1].push(e) : acc.push([e]), acc), []);
            this.premiumPerSeatValues= chunk(premiumSeats, this.seatPerRow);
            console.log(this.premiumPerSeatValues)
            this.classicPerSeatValues = chunk(classicSeats, this.seatPerRow);
            console.log(this.classicPerSeatValues);

        },
        addSeat(seatNumber,seatType) {
            console.log(seatType);
            if(seatType == "PREMIUM"){
                let seatExistence = this.ticket.premiumBookedSeats.includes("P"+seatNumber);
                if(seatExistence){
                    this.ticket.premiumBookedSeats.splice(parseInt(this.ticket.premiumBookedSeats.indexOf("P"+seatNumber)),1);
                }else{
                    this.ticket.premiumBookedSeats.push("P"+seatNumber);
                }
                console.log(this.premiumBookedSeats)
            }
            if(seatType == "CLASSIC"){
                let seatExistence = this.ticket.classicBookedSeats.includes("C"+seatNumber);
                if(seatExistence){
                    this.ticket.classicBookedSeats.splice(parseInt(this.ticket.classicBookedSeats.indexOf("C"+seatNumber)),1);
                }else{
                    this.ticket.classicBookedSeats.push("C"+seatNumber);
                }  
                console.log(this.classicBookedSeats)
            }
        },
        getShowAvailibility(){
            axios.post('http://localhost:8081/api/query/showavailability',this.ticket)
            .then((response) => {
                this.showAvailibility = response.data;
                console.log(response);
            }).catch((error) => {
                console.log(error)
            })
        },
        createTicket(){
            console.log(this.ticket);
            axios.post('http://localhost:8081/api/ticket/new',this.ticket)
            .then((response) => {
                console.log(response);
                this.$router.push({ path: '/payment', query: { ticketId : response.data.id} })
            }).catch((error) => {
                console.log(error)
            })
        }
    },
    beforeMount(){
        this.getAllTicketSeats();
        this.getShowAvailibility();
    }
  
};


</script>

<style>

.text-format{
    font-size: x-large;
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    font-weight: bold;
    color:black;
}

.toggle-on-off{
  font-size: large;
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  font-weight: bold;
  color:brown;
}


.pipe {
    float:left; 
    display:block;
    margin:5px; 
    padding:0 10px; 
    border-left:#ccc solid 1px;
}

.cursor{
    cursor: pointer;
}

.header-margin{
    margin-bottom: 10px;
}

.link-font-size-weight-color{
  font-size: large;
  color:#00BFFF;
}
.link-hover:hover{
  text-decoration: underline;
  color:#17a2b8;
  font-weight: bold;
  
}

.link-font-size-weight-color-collapse{
  font-size: larger;
  color:#ffffff;
}
.link-hover-collapse:hover{
  color:white;
  font-weight: bold;
  
}

.heading-color{
  background-color: #cea4a4;
}

.fs-title-color{
  color:rgb(32, 16, 43);
}

</style>