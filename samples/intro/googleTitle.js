createStep({

	getUrl: function( ctx ) {
		
		return "http://www.google.com";		
	},
	
	run: function( ctx ) {		

		var xml = new XML( ctx.getResponse() );
		
		print( "The title of google.com is " + xml..title +", what a surprise!" );
	}
	
});