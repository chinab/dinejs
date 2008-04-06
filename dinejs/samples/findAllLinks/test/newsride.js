createStep({
	getUrl: function( ctx ) {
		return "http://www.newsride.org";
	},
	run: function( ctx ) {
	
		var xml = new XML( ctx.getResponse() );
			
		for each( var link in xml..a.@href ) 
			print( String(link) );
			
		ctx.addStep( "/test/alombra" );		
	}
});