### Requirements ###

Make sure you have Java 5 or greater installed, if you don't have that, [download it here](http://java.sun.com/javase/downloads/index.jsp).

Grab the [latest release](http://code.google.com/p/dinejs/downloads/list) from dine's project page


### Directory Structure ###

Create 2 folders, one will contain the JavaScript code dine will execute, all output will be written to the other folder

For this guide, let's assume your directory structure looks like this:

> /tmp/dine/

> /tmp/dine/dine-0.3.1-beta-cli.jar

> /tmp/dine/js/

> /tmp/dine/output/

### Executing dine ###

Now go to _/tmp/dine_, open a shell and type _java -jar dine-0.3.1-beta-cli.jar_ to see what parameters dine expects:

```
Usage: java -jar dine-0.3.1-beta-cli.jar <maxConcurrentThreads> <StepsBaseDirectory> <DownloadBaseDirectory> <seedStep>
```

> _maxConcurrentThreads_ is the maximum number of HTTP requests dine will execute concurrently

> _StepsBaseDirectory_ is the directory containing the JavaScript code dine will execute (_/tmp/dine/js_ in this example)

> _DownloadBaseDir_ is the directory where the output is written to (_/tmp/dine/output_ in this example )

> _seedStep_ is the name of the first JavaScript Step dine will execute


### Write your first Step ###

Time to write our first Step! A Step is basically a piece of JavaScript code that tells dine what content to fetch from the internet, which dine will do for you and then the Step can extract whatever information it wants.

Instead of the classical "Hello World", we'll write a step that echoes the page title of google.com.

Create a file called _googleTitle.js_ in _/tmp/dine/js/_ and paste the following code in it:

```
createStep({

	getUrl: function( ctx ) {
		
		return "http://www.google.com";		
	},
	
	run: function( ctx ) {		

		var xml = new XML( ctx.getResponse() );
		
		print( "The title of google.com is " + xml..title +", what a surprise!" );
	}
	
});
```

### Run your first step ###

TIme to execute it! Open a shell and type:

_java -jar dine-0.3.1-beta-cli.jar 1 /tmp/dine/js/ /tmp/dine/output/ /googleTitle_

The output should look similar to this:

_The title of google.com is Google, what a surprise!_


### Understanding the code ###

  * dine will at first call the method _getUrl_ of your step which will return the URI of the website to fetch as a string.

  * Next dine will do the following things:
    1. make a HTTP request to the website located under that URI
    1. fetch the HTML code of that website
    1. convert that HTML to valid XML
    1. save that XML in the context object ( _ctx_ )
    1. call the method _run_ of your step with the context object as an argument

  * the XML can now be accessed via _ctx.getResponse()_, the above code builds and uses an E4X object from that, which allows for very simple and easy XML parsing


### Learn more ###

dine can do much more things, such as trigger new steps, pass params to steps, retrieve JSON...

Check the [samples](Samples.md) and [tutorials](Tutorials.md) to learn more.

Also, feel free to comment this page,if you feel something misses or is not really well understandable in this introduction.