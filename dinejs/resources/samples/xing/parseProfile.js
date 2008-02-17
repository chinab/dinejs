createStep({
	getUrl: function() {
		return this.memory.url;
	},
	run: function() {		
			
			var name			 = String( this.xmlObj..title ).replace(/XING - /, "");
			var occupation = this.xmlObj..p.(@className="profile-work-descr")..a[0];
			
			print( name+" --- "+occupation );
	}
});