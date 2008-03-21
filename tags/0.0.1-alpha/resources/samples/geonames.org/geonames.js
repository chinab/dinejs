createStep({
	getUrl: function() {
		return "http://ws.geonames.org/searchJSON?q="+this.getLocation()+"&maxRows=10";
	},
	run: function() {		

		var result = <result/>
		
		for ( var n=0 ; n<this.jsonObj.totalResultsCount ; n++ )		
			result.appendChild( <place lat={this.jsonObj.geonames[n].lat} lng={this.jsonObj.geonames[n].lng}>{this.jsonObj.geonames[n].name}</place> );
		
		print( result.toXMLString() );
		
		createFile( this.getLocation()+".xml", "<?xml version=\"1.0\"?>\n"+result.toXMLString() );

	},
	
	getLocation: function () {
		return "Alexanderplatz,Berlin";
	}
	
});