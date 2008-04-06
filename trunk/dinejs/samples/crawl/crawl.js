createStep({
	getUrl: function( ctx ) {
		return ctx.getParam("url");
	},
	run: function( ctx ) {

		var xml = new XML( ctx.getResponse() );
	
		for each( var link in xml..a.@href ) {
		
			var next = String(link); 
			
			if ( this.isInternalLink( next ) == true ) {
			
				next = "http://newsride.org/"+next;
								
				if ( ctx.getMemory().hasKey( next ) == false ) {
				
					print( "adding:"+next );
					
					ctx.getMemory().put( next, "" );
					ctx.addStep("/crawl", createMap( { "url": next } ) );
				}

			}
		}
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