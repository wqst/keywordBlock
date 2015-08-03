/*
    create buttons for popup
*/
function buttonFacebook() {
    //query is to gets all tabs that have the specified properties
    chrome.tabs.query({
        active: !0,
        currentWindow: !0
    }, function(a) {
        a && chrome.windows.create({ //create pop-up window and check click
            //encodeURIComponent encodes an URI componet http://www.w3schools.com/jsref/jsref_encodeURIComponent.asp
            //Combo: website + url + title
            url: "http://www.facebook.com/sharer/sharer.php?u=" + encodeURIComponent(a[0].url) + "&t=" + encodeURIComponent(a[0].title),
            width: 600,
            height: 460,
            type: "popup",
            focused: !0
        })
    })
}
 
function buttonTwitter() {
    chrome.tabs.query({
        active: !0,
        currentWindow: !0
    }, function(a) {
        a && chrome.windows.create({
            url: "https://twitter.com/intent/tweet?url=" + encodeURIComponent(a[0].url) + "&text=" + encodeURIComponent(a[0].title),
            width: 600,
            height: 460,
            type: "popup",
            focused: !0
        })
    })
}
 
function buttonGooglePlus() {
    chrome.tabs.query({
        active: !0,
        currentWindow: !0
    }, function(a) {
        a && chrome.windows.create({
            url: "https://plus.google.com/share?url=" + encodeURIComponent(a[0].url),
            width: 600,
            height: 460,
            type: "popup",
            focused: !0
        })
    })
}
 
function buttonEmail() {
    chrome.tabs.query({
        active: !0,
        currentWindow: !0
    }, function(a) {
        if (a)
            //localStorage is to store the info in the local browser http://www.w3schools.com/html/html5_webstorage.asp
            if ("0" != localStorage.ogmail) { //judge whether local browser use gmail, if not then set it to gmail
                var b = "https://mail.google.com/",
                    c = localStorage.gappsdomain;
                c && (b += "a/" + c + "/");
                b += "mail/?view=cm&fs=1&tf=1&su=" + encodeURIComponent(a[0].title) + "&body=" + encodeURIComponent(a[0].url);
                chrome.windows.create({
                    url: b,
                    width: 640,
                    height: 480,
                    type: "popup",
                    focused: !0
                })
            } else chrome.tabs.update(a[0].id, {
                url: "mailto:?subject=" + encodeURIComponent(a[0].title) + "&body=" + encodeURIComponent(a[0].url)
            })
    })
}
 
// Create the eventlistener for click 
document.addEventListener("DOMContentLoaded", function() {
    "0" == localStorage.ofacebook ? document.getElementById("liFacebook")
        .style.display = "none" : document.getElementById("liFacebook")
        .addEventListener("click", buttonFacebook);
    "0" == localStorage.otwitter ? document.getElementById("liTwitter")
        .style.display = "none" : document.getElementById("liTwitter")
        .addEventListener("click", buttonTwitter);
    "0" == localStorage.ogoogleplus ? document.getElementById("liGooglePlus")
        .style.display = "none" : document.getElementById("liGooglePlus")
        .addEventListener("click",
            buttonGooglePlus);
    "0" == localStorage.oemail ? document.getElementById("liEmail")
        .style.display = "none" : document.getElementById("liEmail")
        .addEventListener("click", buttonEmail);
});