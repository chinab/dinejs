createStep({
	getUrl: function() {
		return this.params.url;
	},
	run: function() {		
			out.println( "Checking "+this.memory.url+" "+String(this.httpResponseCode) );
	}
});