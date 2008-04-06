createStep({
	getUrl: function( ctx ) {
		return "http://www.elitepartner.de/km/registration/genderHomepageRegistration.do";
	},
	
	getMethod: function() {
		return "POST";
	},
	
	getPostParams: function() {
		return createMap({ geschlecht: "m", email: "bla3000@emaildienst.de" });	
	},
	
	run: function( ctx ) {
	
		print( ctx.getResponse() );
	}
});