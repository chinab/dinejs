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