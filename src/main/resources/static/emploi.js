let listCustomers = [];
let section = document.getElementById("section").value;

document.addEventListener("DOMContentLoaded", function () {
    let listemploi = [];



    const HOURS = [
        "8:00 - 9:00",
        "9:00 - 10:00",
        "10:00 - 11:00",
        "11:00 - 12:00",
        "12:00 - 13:00",
        "13:00 - 14:00",
        "14:00 - 15:00",
        "15:00 - 16:00",
        "16:00 - 17:00",
        "17:00 - 18:00",
        "18:00 - 19:00"
    ];

    const DAYS = [
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    ];

    const BACKGROUNDS = [
        "#FFAC00",
        "#ABFF9C",
        "#FF632E",
        "#FF3DA9",
        "#AA49FF",
        "#41FFAC",
        "#0028B2",
        "#FFFFFF",
        "#AAB291",
        "#FFD619",
        '#9B9AFF',
        '#FF7E19',
        '#FFFF19',
        '#B2585C',
        '#0A00B2',
        '#FF199D'
    ];
    let history = [];

    let BG_USED = new Array(BACKGROUNDS.length);
    for(let i=0; i<BG_USED.length; i++)
        BG_USED[i] = 0;

    const BG_OPACITY = 60;

    let timetable = document.getElementById("timetable");

    for(let i=0; i<12; i++) {
        let div = document.createElement("div");
        div.classList.add("row");
        for(let j=0; j<8; j++) {
            if(i==0) {
                if(j==0) {
                    div.innerHTML += `<span class="cell highlight">Days &rarr;<br>Time &darr;</span>`;
                } else {
                    div.innerHTML += `<span class="cell highlight">${DAYS[j-1]}</span>`;
                }
            } else if (j==0) {
                div.innerHTML += `<span class="cell highlight">${i}: ${HOURS[i-1]}</span>`;
            } else {
                div.innerHTML += `<span class="cell"></span>`;
            }
        }
        timetable.appendChild(div);
    }
    let arrr = [];
    let cells = document.getElementsByClassName("cell");
    let addBtn = document.getElementById("add-btn");
    console.log('listemploi :'+listemploi.length);
    $.ajax({
        type : "GET",
        url : "/api/emploi/"+section,
        success: function(result){

            $.each(result, function(i, customer){
                var customer = "{"+
                    " \"matiere\": "+"\"" +customer.matiere +"\""+
                    " , \"classe\": " +"\"" + customer.classe +"\""+
                    ", \"enseignant\": " +"\"" + customer.enseignant +"\""+
                    ", \"days\": " + "" +customer.days +""+
                    ", \"hours\": " +"" + customer.hours +""+
                    "}";
                listemploi.push(JSON.parse(customer))
                // console.log(customer);
                // console.log(  JSON.stringify(customer));
            })
            for(let d=0; d<listemploi.length; d++){
                let day = Number(listemploi[d].days);
                console.log('day :'+day)
                let hour = Number(listemploi[d].hours);
                arrr.push(hour*8 + day);
                cells[hour*8 + day].innerHTML = `<strong>${listemploi[d].matiere}</strong>${listemploi[d].enseignant}<br>${listemploi[d].classe}`;
                let random = Math.floor(Math.random() * (BACKGROUNDS.length));
                cells[hour*8 + day].style.background = BACKGROUNDS[random] + BG_OPACITY.toString();

            }


        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });




});

$(document).ready(function() {
    $('#days').select2();
    $('#hours').select2();
});


