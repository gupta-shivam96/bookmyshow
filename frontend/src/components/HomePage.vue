<template>

<div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">bookmyshow</a>
            <!--<button  class="btn" style="margin-right:20px" > <span data-toggle="modal" data-target="#cityModal">SLl</span>Click</button>
             Button trigger modal -->
            <button type="button" style="margin-right:20px" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
            {{selectedCity}}
            </button>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal"  role="dialog" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                    <div class="modal-body">
                            <!-- City List-->
                            <div class="table-responsive">
                                <table class="table cursor">
                                    <tbody>
                                        <tr>
                                            <td v-for="city in cities" :key="city.id"><a href="" v-on:click.prevent="getMovies(city.name)" >{{city.name}}</a></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </nav>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#" >Movies</a>
        </div>
    </nav>
</div>

<div id="carouselExampleInterval" class="carousel slide card-margin" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active" data-bs-interval="1000">
            <img src="../assets/lake.jpg" class="d-block w-100" height="300" alt="...">
        </div>
        <div class="carousel-item" data-bs-interval="2000">
            <img src="../assets/beer.jpg" class="d-block w-100" height="300" alt="...">
        </div>
        <div class="carousel-item">
            <img src="../assets/shimla.jpg" class="d-block w-100" height="300" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>

<div class="card card-margin" >
  <div class="card-body">
    <h3>Recomended Movies</h3>
    <div class="table-responsive">
        <table class="table cursor">
            <tbody>
                <tr>
                    <td v-for="movie in movies" :key="movie.id">
                        <a href="">
                        <div class="card" style="width: 18rem;">
                            <img class="card-img-top" src="../assets/batman.jpg" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text">{{movie.name}}</p>
                            </div>
                        </div>
                        </a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
  </div>
</div>

</template>

<script>
import axios from 'axios'
export default {
    name: 'HomePage',
    data () {
        return {
            cities: [],
            movies: [],
            rowsLength: 0,
            selectedCity: ""
        }
    },
    methods : {
        getCities() {
            axios.get('http://localhost:8081/api/cities')
                .then((response) => {
                    console.log(response.data)
                    this.cities = response.data;
                    this.selectedCity = this.cities[0].name;
                    this.getMovies(this.selectedCity);
                    //this.rowsLength = Math.ceil(response.data.length/6);
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        getMovies(cityName) {
            console.log(cityName);
            this.selectedCity = cityName;
            axios.get('http://localhost:8081/api/movies/'+this.selectedCity)
                .then((response) => {
                    console.log(response.data)
                    this.movies = response.data;
                })
                .catch((error) => {
                    console.log(error)
                })

        }
    },
    beforeMount(){
        this.getCities();
    }
}
</script>

<style>
h3 {
  float: left;
  margin-bottom: 20px;
  margin-top: 20px;
  margin-left:10px;
  text-align: left !important;
  width: 100%;
}

.card {
    background-color: rgb(252, 250, 250);
}

.card-margin {
    margin-top: 10px;
}

.container-fluid{
      padding-left: 0;
      padding-right: 0;
}

.cursor{
    cursor: pointer;
}


</style>