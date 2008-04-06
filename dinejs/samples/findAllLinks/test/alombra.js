createStep({
	getUrl: function( ctx ) {
		return "http://www.alombra.de";
	},
	run: function( ctx ) {

		var xml = new XML( ctx.getResponse() );
	
		for each( var link in xml..a.@href ) 
			print( String(link) );
	}
});