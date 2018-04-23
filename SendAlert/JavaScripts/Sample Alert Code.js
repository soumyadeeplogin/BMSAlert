// ==UserScript==
// @name         Prasad Tickets
// @namespace    http://tampermonkey.net/
// @version      0.1
// @description  try to take over the world!
// @author       sroy
// @match        https://in.bookmyshow.com/buytickets/prasads-hyderabad/cinema-hyd-PRHN-MT/20180422
// @grant        none
// ==/UserScript==

(function() {
    'use strict';

    var date = document.getElementsByClassName("date-container")[0].innerText;
    if(date.match(/27/g)!=null)
    {
        console.log("Got it");
        document.location.href = "http://tyrion:8080/SendAlert/HallAlert?prasads-hyderabad";
    } else {
        setTimeout(function()
        {
            console.log("Reload");
            location.reload();
        },1800000);
    }
})();