createStep({
	getUrl: function() {
		
		if ( typeof( this.params.url ) == "undefined" )
			return this.getRootUrl();
		
		return this.params.url;
	},
	
	run: function() {		
				
		print( "Checking " + this.getUrl() );
				
		for each( var link in this.xmlObj..a.@href ) 
			if ( !link.match(/:\/\//) && !link.match(/^#/) )
				addStep("crawling/findInternalLinks", { url: this.createNewUrl( link ) });
				
	},
	
	getRootUrl: function() {
		return "http://www.alombra.de/";
	},
	
	createNewUrl: function( link ) {
		return this.getRootUrl()+String(link);
	}
});