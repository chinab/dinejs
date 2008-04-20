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
			
				if ( !next.match(/^\//) ) {
					next = "/"+next;
				}
				
				next = this.getRootUrl()+next;
								
				if ( ctx.getMemory().hasKey( next ) == false ) {
				
					//print( "visiting: "+next );
					
					ctx.getMemory().put( next, "" );
					ctx.addStep("/visitEveryPage", createMap( { "url": next } ) );
				}

			}
			
			if ( next.match(/^mailto:/) ) {
			
				// some normalization...
				var email = next.substring( next.indexOf(":")+1, next.length );
				email = email.replace( " at ", "@");
				email = email.replace( / /g, "" );
				email = email.replace( "[at]", "@" );
				email = email.replace( "(at)", "@" );
				
				// the corresponding url:
				var url;
				
				if ( ctx.hasParam("url") == false ) {
					url = this.getRootUrl();
				}
				else {
					url = ctx.getParam("url");
				}
				
				print( email+"    ["+url+"]" );
			}
		}
	},
	
	getRootUrl: function() {
		return "http://www.phpcenter.de";
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