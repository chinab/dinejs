createStep({
	getUrl: function() {
		
		if ( typeof( this.params.url ) == "undefined" )
			return this.getRootUrl();
		
		return this.params.url;
	},
	
	run: function() {		
				
		print( "Checking " + this.getUrl() );
				
		for each( var link in this.xmlObj..a.@href ) {
				
			if ( this.isInternalLink( link ) == true ) {
			
				var url = this.createNewUrl( link );
			
				if ( this.inMemory( url ) == false ) {
							
					this.addToMemory( url, true );																			
					addStep("crawling/findInternalLinks", { url: url });
				}
			}
		}	
	},
	
	getRootUrl: function() {
		return "http://www.crawlthisdomain.com/";
	},
	
	createNewUrl: function( link ) {
		return this.getRootUrl()+String(link);
	},
	
	isInternalLink: function( link ) {
		return ( 							
							!link.match(/:\/\//) && 
							!link.match(/^#/) && 
							!link.match(/^mailto:/) && 
							!link.match(/^javascript:/)
					);
	}
});