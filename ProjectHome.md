# dine #

... is a multithreaded Java HTTP-Client that can be programmed in Javascript, it currently understands HTML, XML and JSON.

Although there is no stable official release at the moment, dine is already used in productive application environments.

# Overview #

![http://dinejs.googlecode.com/svn/trunk/dinejs/resources/doc/dine.gif](http://dinejs.googlecode.com/svn/trunk/dinejs/resources/doc/dine.gif)

  1. **dine maintains a queue of so called steps written in JavaScript, which control its behavior**
  1. **for each step, dine will fetch the content of its requested website via HTTP**
  1. **dine will then convert the website's HTML to XML and make that available to the step code**
  1. **after that the step can parse the XML, trigger new steps and much more**


# How does the code look like? #

Instead of "Hello World", we'll show the Javascript step code necessary to print the page title of _google.com_ as an example:

```
createStep({
        getUrl: function( ctx ) {
                return "http://www.google.com";
        },
        run: function( ctx ) {               
                var xml = new XML(  ctx.getResponse() );
                print( "The title of google.com is " + xml..title + ", what a surprise!" );
        }
});
```

# Wanna know more? #

Check  the [Getting started](GettingStarted.md), [Tutorials](Tutorials.md) or [Samples](Samples.md) page!