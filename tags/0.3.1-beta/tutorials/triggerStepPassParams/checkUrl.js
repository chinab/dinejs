createStep({
	getUrl: function( ctx ) {
		// the location of the page to check is saved in the "url" parameter
		return ctx.getParam("url");
	},
	run: function( ctx ) {

		// HTTP response code 200 means the site is available
		if ( ctx.getResponseCode() == 200 ) {
			print( "everything's ok for " + ctx.getParam("url") );
		}
		else {
			print( ctx.getParam("url") + " is not available!" );
		}
	}
});