# Scenario #

Consider the following use-case: I would like to find all outgoing links on my FAQ page and have dine check whether the linked sites are still available.

This requires 2 steps to be written, one that finds all outgoing links and another one that checks each outgoing link.

The first one will have to trigger the execution of the second one and it needs a way of telling it which link to check.

# Code #

## Finding all links: _allLinks.js_ ##
```
createStep({
	getUrl: function( ctx ) {
		return "http://code.google.com/p/dinejs/wiki/FAQ";
	},
	run: function( ctx ) {

		// create E4X object from the response
		var xml = new XML( ctx.getResponse() );
	
		// find all links 
		for each( var a in xml..a.@href ) {
		
			var link = String( a );
			
			// outgoing links start with "http"
			if ( link.match(/^http/) ) { 

				// trigger the execution of checkUrl for this outgoing link
				ctx.addStep("/checkUrl", createMap({ url: link }) );
			}
		}
	}
});
```

This step finds all links on my FAQ page and checks whether they are outgoing links ( all outgoing links start with _http_).

Then it triggers the execution of the next step and gives the link as a param to it in this line:

_ctx.addStep("/checkUrl", createMap({ url: link }) );_

That code means the following: execute the step defined in _/checkUrl.js_ and save the content of the variable _link_  as a param for it under the name _url_.


## Checking a link: _checkUrl.js_ ##

```
createStep({
	getUrl: function( ctx ) {
		// the location of the page to check is saved in the "url" parameter
		return ctx.getParam("url");
	},
	run: function( ctx ) {

		// HTTP response code 200 means the site is available
		if ( ctx.getResponseCode() == 200 ) {
			print( "everything's ok for " + ctx.getParam("url") );
		}
		else {
			print( ctx.getParam("url") + " is not available!" );
		}
	}
});
```

You can see that this step uses the parameter _url_ given to it by it's parent step _/allLinks_. It will be executed for each outgoing link that is found by _/allLinks_.

# Output #

```
everything's ok for http://www.google.com/privacy.html
everything's ok for http://en.wikipedia.org/wiki/Code_talker#Use_of_Navajo
everything's ok for http://en.wikipedia.org/wiki/Navajo_language
everything's ok for http://en.wikipedia.org/wiki/E4X
everything's ok for http://www.google.com/accounts/Login?continue=http%3A%2F%2Fcode.google.com%2Fp%2Fdinejs%2Fwiki%2FFAQ&followup=http%3A%2F%2Fcode.google.com%2Fp%2Fdinejs%2Fwiki%2FFAQ
everything's ok for http://en.wikipedia.org/wiki/Command_pattern
everything's ok for http://www.google.com/accounts/Login?continue=http%3A%2F%2Fcode.google.com%2Fp%2Fdinejs%2Fwiki%2FFAQ&followup=http%3A%2F%2Fcode.google.com%2Fp%2Fdinejs%2Fwiki%2FFAQ
everything's ok for http://developer.mozilla.org/en/docs/E4X_tutorial
everything's ok for http://en.wikipedia.org/wiki/Singleton_pattern
```