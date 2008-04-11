createStep({

	getUrl: function( ctx ) {
	
		if ( ctx.hasParam("url") == false ) {
			return this.getRootUrl();
		}
	
		return ctx.getParam("url");
	},
	
	run: function( ctx ) {

		var xml = new XML( ctx.getResponse() );
	
		for each( var link in xml..a.@href ) {
		
			var next = String(link); 
			
			if ( this.isInternalLink( next ) == true ) {
			
				next = this.getRootUrl()+next;
								
				if ( ctx.getMemory().hasKey( next ) == false ) {
				
					print( "adding: "+next );
					
					ctx.getMemory().put( next, "" );
					ctx.addStep("/visitEveryPage", createMap( { "url": next } ) );
				}

			}
		}
	},
	
	getRootUrl: function() {
		return "http://newsride.org";
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