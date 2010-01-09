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
									
					ctx.getMemory().put( next, "" );
					ctx.addStep("/visitEveryPage", createMap( { "url": next } ) );
				}

			}
			
			if ( next.match(/^mailto:/) ) {

				var email = this.getEmailAddressFromLink( next );
				
				if ( ctx.getMemory().hasKey( email ) == false ) {
				
				  ctx.getMemory().put( email, "" );
				  print( email );
				}
			}
		}
	},
	
	getEmailAddressFromLink: function( link ) {
	
		
		var email = String( link );
		
		email = email.substring( email.indexOf(":")+1, email.length );
		
		if ( email.indexOf("?") != -1 ) {
			email = email.substring( 0, email.indexOf("?") );
		}
		
		email = email.replace( " at ", "@");
		email = email.replace( / /g, "" );
		email = email.replace( "[at]", "@" );
		email = email.replace( "(at)", "@" );	
		
		return email;
	},
	
	getRootUrl: function() {
		return "http://www.berlin.de";
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