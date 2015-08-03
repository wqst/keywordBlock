chrome.contextMenus.onClicked.addListener(function(a, d) { // d is title
            var b = a.pageUrl //pageurl
    if ("Share-G1" == a.menuItemId) { //facebook
        //judge whether it is a mediatype and determine whether b is srcUrl or linkUrl http://en.wikipedia.org/wiki/Internet_media_type
         (a.mediaType ? b = a.srcUrl : b = a.linkUrl,  chrome.windows.create({ //difference among pageUrl, srcUrl and linkUrl: http://dart-gde.github.io/chrome_gen.dart/ext/chrome.contextMenus/OnClickData.html
            url: "http://www.facebook.com/sharer/sharer.php?u=" + encodeURIComponent(b) + "&t=" + encodeURIComponent(d.title),
            width: 600,
            height: 460,
            type: "popup",
            focused: !0
        })
    } else "Share-G2" == a.menuItemId ? (a.mediaType ? b = a.srcUrl : b = a.linkUrl, chrome.windows.create({
        url: "https://twitter.com/intent/tweet?url=" + encodeURIComponent(b) + "&text=" + encodeURIComponent(d.title), //twitter
        width: 600,
        height: 460,
        type: "popup",
        focused: !0
    })) : "Share-G3" == a.menuItemId ? (a.mediaType ? b = a.srcUrl : b = a.linkUrl, chrome.windows.create({
            url: "https://plus.google.com/share?url=" + encodeURIComponent(b), //google+
            width: 600,
            height: 460,
            type: "popup",
            focused: !0
    })) : "Share-G4" ==  a.menuItemId ? (a.mediaType ? b = a.srcUrl : b = a.linkUrl, chrome.windows.create({
            url: "https://mail.google.com/mail/?view=cm&fs=1&tf=1&su=" + encodeURIComponent(d.title) + "&body=" + encodeURIComponent(b), //gmail
            width: 640,
            height: 480,
            type: "popup",
            focused: !0
        })) : chrome.tabs.update(d.id, {
            url: "mailto:?subject=" + encodeURIComponent(d.title) + "&body=" + encodeURIComponent(b)
        }))
});

//Create the listener
chrome.runtime.onInstalled.addListener(function() {
chrome.contextMenus.create({
        title: "Share",
        contexts: ["all"],
        id: "Share-Gparent" //main button to click
    }), chrome.contextMenus.create({
        title: "Facebook",
        contexts: ["all"],
        parentId: "Share-Gparent", //show the child button when click on parent id
        id: "Share-G1"
    }), chrome.contextMenus.create({
        title: "Twitter",
        contexts: ["all"],
        parentId: "Share-Gparent",
        id: "Share-G2"
    }), chrome.contextMenus.create({
        title: "Google+",
        contexts: ["all"],
        parentId: "Share-Gparent",
        id: "Share-G3"
    }), chrome.contextMenus.create({
        title: "Email",
        contexts: ["all"],
        parentId: "Share-Gparent",
        id: "Share-G4"
    }))
});