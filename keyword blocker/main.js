exports.main = function() {};

pageMod.PageMod({
    include: "*.twitter.com",
    contentStyleFile: [
        data.url("CSS/filter.css"), 
    ],
    contentScriptWhen: 'ready',
    contentScriptFile: [
         data.url("lib/jquery/jquery-1.7.1.min.js")
        ,data.url("lib/jquery/jquery-ui-1.8.16.custom.min.js")
        ,data.url("js/ko/knockout-2.1.0.js")
        ,data.url("lib/ko/knockout.localStorage-latest.js") 
        ,data.url("lib/coffeekup/coffekup.js")
    ]
});