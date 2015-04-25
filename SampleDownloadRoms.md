# Code #

```
createStep({
	getUrl: function( ctx ) {
		return "http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/NES_roms_summary%200-L.htm";
	},
	run: function( ctx ) {
	
		// create an E4X object from the XML response
		var xml = new XML( ctx.getResponse() );
	
		// find all links on the page
		for each( var link in xml..a.@href ) {
		
			nesLink = String( link );
			
			// do they link to a .zip file?
			if ( nesLink.match(/.zip$/) ) {  
				
				// complete url to zip file
				var downloadUrl = "http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/"+escape( nesLink );				
				
				// trigger download
				ctx.addDownload( downloadUrl, nesLink );				
			}
		}
	}
});
```

# Sample Output #

```
13:10:44,644 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/10%20Yard%20Fight.zip to 10 Yard Fight.zip
13:10:44,654 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/100WorldStory%2CThe.zip to 100WorldStory,The.zip
13:10:44,664 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/1942.zip to 1942.zip
13:10:44,674 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/1943.zip to 1943.zip
13:10:44,688 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/3D%20Battles%20of%20World%20Runner.zip to 3D Battles of World Runner.zip
13:10:44,698 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/4%20Card%20Games.zip to 4 Card Games.zip
13:10:44,708 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/4%20Wheel%20Battle.zip to 4 Wheel Battle.zip
13:10:44,719 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/720%20Degrees.zip to 720 Degrees.zip
13:10:44,729 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/8%20Eye%27s.zip to 8 Eye's.zip
13:10:44,739 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/A%20Boy%20%26%20His%20Blob.zip to A Boy & His Blob.zip
13:10:44,750 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/A.S.O.zip to A.S.O.zip
13:10:44,762 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Abadox.zip to Abadox.zip
13:10:44,770 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Achikoch.zip to Achikoch.zip
13:10:44,781 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Action%2052.zip to Action 52.zip
13:10:44,791 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/AD%26D%20Heros%20of%20the%20Lance.zip to AD&D Heros of the Lance.zip
13:10:44,801 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/AD%26D%20Hillsfar.zip to AD&D Hillsfar.zip
13:10:44,812 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/AD%26D%20Pool%20of%20Radiance.zip to AD&D Pool of Radiance.zip
13:10:44,822 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Addams%20Family%20Pugsley%27s%20Scavenger%20Hunt.zip to Addams Family Pugsley's Scavenger Hunt.zip
13:10:44,832 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Addams%20Family%20Uncle%20Festers%20Quest.zip to Addams Family Uncle Festers Quest.zip
13:10:44,843 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Addams%20Family.zip to Addams Family.zip
13:10:44,853 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Advebtures%20of%20Gilligan%27sIsland.zip to Advebtures of Gilligan'sIsland.zip
13:10:44,863 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Adventure%20Island%201.zip to Adventure Island 1.zip
13:10:44,874 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Adventure%20Island%202.zip to Adventure Island 2.zip
13:10:44,886 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Adventure%20Island%203.zip to Adventure Island 3.zip
13:10:44,894 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Adventure%20Island%204.zip to Adventure Island 4.zip
13:10:44,904 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Adventures%20in%20Magic%20Kingdom.zip to Adventures in Magic Kingdom.zip
13:10:44,914 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Adventures%20of%20Bayou%20Billy.zip to Adventures of Bayou Billy.zip
13:10:44,925 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Adventures%20of%20CaptainCosmic.zip to Adventures of CaptainCosmic.zip
13:10:44,935 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Adventures%20of%20Dino%20Riki.zip to Adventures of Dino Riki.zip
13:10:44,946 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Adventures%20of%20Lolo%201.zip to Adventures of Lolo 1.zip
13:10:44,957 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Adventures%20of%20Lolo%202.zip to Adventures of Lolo 2.zip
13:10:44,967 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Adventures%20of%20Lolo%203.zip to Adventures of Lolo 3.zip
13:10:44,977 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Adventures%20of%20Musashi.zip to Adventures of Musashi.zip
13:10:44,988 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Adventures%20of%20Rad%20Gravity.zip to Adventures of Rad Gravity.zip
13:10:44,998 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Adventures%20of%20Rocky%20%26%20Bullwinkle.zip to Adventures of Rocky & Bullwinkle.zip
13:10:45,008 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Adventures%20of%20Tom%20Sawyer.zip to Adventures of Tom Sawyer.zip
13:10:45,018 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Adventures%20of%20Valecule.zip to Adventures of Valecule.zip
13:10:45,029 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Afro%20Mario%20Brothers.zip to Afro Mario Brothers.zip
13:10:45,040 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Afterburner%201.zip to Afterburner 1.zip
13:10:45,050 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Afterburner%202.zip to Afterburner 2.zip
13:10:45,061 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Air%20Fortress.zip to Air Fortress.zip
13:10:45,071 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Airwolf.zip to Airwolf.zip
13:10:45,082 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Al%20Unser%20Jr%27s%20Trbo%20Racing.zip to Al Unser Jr's Trbo Racing.zip
13:10:45,094 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Aladdin.zip to Aladdin.zip
13:10:45,103 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Alfred%20the%20Chicken.zip to Alfred the Chicken.zip
13:10:45,114 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Alien%203.zip to Alien 3.zip
13:10:45,125 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Alien%20Syndrome.zip to Alien Syndrome.zip
13:10:45,136 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/All-Pro%20Basketball.zip to All-Pro Basketball.zip
13:10:45,146 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Alpha%20Mission.zip to Alpha Mission.zip
13:10:45,157 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Altered%20Beast.zip to Altered Beast.zip
13:10:45,167 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Amagon.zip to Amagon.zip
13:10:45,178 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/American%20Gladiator.zip to American Gladiator.zip
13:10:45,188 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Animal%20Attack.zip to Animal Attack.zip
13:10:45,198 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Animations%20%28NottheGame%29.zip to Animations (NottheGame).zip
13:10:45,209 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Antarctic%20Adventure.zip to Antarctic Adventure.zip
13:10:45,219 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Anticipation.zip to Anticipation.zip
13:10:45,229 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Arabian.zip to Arabian.zip
13:10:45,240 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Arc%20Hon%20%20%28Battal%20Chess%29.zip to Arc Hon  (Battal Chess).zip
13:10:45,250 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Arch%20Rivals.zip to Arch Rivals.zip
13:10:45,260 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Archon.zip to Archon.zip
13:10:45,271 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Argus.zip to Argus.zip
13:10:45,281 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Arkanoid.zip to Arkanoid.zip
13:10:45,292 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Arkista%27s%20Ring.zip to Arkista's Ring.zip
13:10:45,302 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Armed%20Dragon%20Fantasy%20Villgust.zip to Armed Dragon Fantasy Villgust.zip
13:10:45,320 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Asterix.zip to Asterix.zip
13:10:45,333 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Astro%20Fang%20SuperMachine.zip to Astro Fang SuperMachine.zip
13:10:45,343 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Astro%20Robo.zip to Astro Robo.zip
13:10:45,359 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Astynax.zip to Astynax.zip
13:10:45,370 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Athena.zip to Athena.zip
13:10:45,382 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Atlantis.zip to Atlantis.zip
13:10:45,393 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Attack%20of%20the%20Killer%20Tomatoes.zip to Attack of the Killer Tomatoes.zip
13:10:45,407 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Baby%20Boomer.zip to Baby Boomer.zip
13:10:45,417 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Back%20to%20the%20Future%201.zip to Back to the Future 1.zip
13:10:45,428 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Back%20to%20the%20Future%202%20%263.zip to Back to the Future 2 &3.zip
13:10:45,438 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bad%20Dudes.zip to Bad Dudes.zip
13:10:45,448 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bad%20News%20Baseball.zip to Bad News Baseball.zip
13:10:45,459 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bad%20Street%20Brawler.zip to Bad Street Brawler.zip
13:10:45,469 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Badmnton.zip to Badmnton.zip
13:10:45,479 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Ball%20Blazer.zip to Ball Blazer.zip
13:10:45,490 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Balloon%20Fighter.zip to Balloon Fighter.zip
13:10:45,500 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Baltron.zip to Baltron.zip
13:10:45,512 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Banana.zip to Banana.zip
13:10:45,521 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bandit%20Kings%20of%20Ancient%20China.zip to Bandit Kings of Ancient China.zip
13:10:45,532 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Barbie.zip to Barbie.zip
13:10:45,542 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bart%20vs%20Spacemutants.zip to Bart vs Spacemutants.zip
13:10:45,552 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bart%20vs%20the%20World.zip to Bart vs the World.zip
13:10:45,562 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bartman%20Meets%20Radioactive%20Man.zip to Bartman Meets Radioactive Man.zip
13:10:45,574 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Base%20Ball%20Stars%202.zip to Base Ball Stars 2.zip
13:10:45,584 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Baseball%20Legends%20of%20the%20Diamon.zip to Baseball Legends of the Diamon.zip
13:10:45,594 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Baseball%20Simulator1000.zip to Baseball Simulator1000.zip
13:10:45,605 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Baseball%20Stars.zip to Baseball Stars.zip
13:10:45,616 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bases%20Loaded%201.zip to Bases Loaded 1.zip
13:10:45,627 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bases%20Loaded%202.zip to Bases Loaded 2.zip
13:10:45,638 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bases%20Loaded%203.zip to Bases Loaded 3.zip
13:10:45,648 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Basewars.zip to Basewars.zip
13:10:45,658 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Batman%201.zip to Batman 1.zip
13:10:45,669 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Batman%202.zip to Batman 2.zip
13:10:45,679 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Batman%203.zip to Batman 3.zip
13:10:45,689 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Battle%20Chess.zip to Battle Chess.zip
13:10:45,700 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Battle%20City.zip to Battle City.zip
13:10:45,710 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Battle%20Field.zip to Battle Field.zip
13:10:45,727 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Battle%20Ship.zip to Battle Ship.zip
13:10:45,737 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Battle%20Tank.zip to Battle Tank.zip
13:10:45,748 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Battle%20Toads%20%26%20DoubleDragon.zip to Battle Toads & DoubleDragon.zip
13:10:45,758 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Battletoads.zip to Battletoads.zip
13:10:45,790 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bee%2052.zip to Bee 52.zip
13:10:45,798 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Beetlejuice.zip to Beetlejuice.zip
13:10:45,810 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Best%20of%20the%20Best.zip to Best of the Best.zip
13:10:45,823 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bible%20Adventures.zip to Bible Adventures.zip
13:10:45,841 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bible%20Buffet.zip to Bible Buffet.zip
13:10:45,851 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Big%20Brid%27s%20Hide%20%26%20Speek.zip to Big Brid's Hide & Speek.zip
13:10:45,861 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Big%20Nose%20Freaks%20Out.zip to Big Nose Freaks Out.zip
13:10:45,872 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Big%20Nose%20the%20Caveman.zip to Big Nose the Caveman.zip
13:10:45,882 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bigfoot.zip to Bigfoot.zip
13:10:45,894 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bill%20%26%20Ted%27s%20Excellent%20Adventure.zip to Bill & Ted's Excellent Adventure.zip
13:10:45,904 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Binary%20Land.zip to Binary Land.zip
13:10:45,914 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bionic%20Commando.zip to Bionic Commando.zip
13:10:45,929 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bird%20Week.zip to Bird Week.zip
13:10:45,939 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Birdy%20Rush.zip to Birdy Rush.zip
13:10:45,949 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Black%20Bass.zip to Black Bass.zip
13:10:45,965 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Black%20Mage%20Mario.zip to Black Mage Mario.zip
13:10:45,986 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Black%20Onyx.zip to Black Onyx.zip
13:10:45,994 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Blades%20of%20Steel.zip to Blades of Steel.zip
13:10:46,011 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Blaster%20Master.zip to Blaster Master.zip
13:10:46,021 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Blue%20Marlin.zip to Blue Marlin.zip
13:10:46,032 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Blue%20Shadow.zip to Blue Shadow.zip
13:10:46,049 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Blues%20Brothers.zip to Blues Brothers.zip
13:10:46,059 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bo%20Jackson%20Baseball.zip to Bo Jackson Baseball.zip
13:10:46,070 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bokosuka%20Wars.zip to Bokosuka Wars.zip
13:10:46,084 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bomber%20King.zip to Bomber King.zip
13:10:46,105 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bomber%20Man%201.zip to Bomber Man 1.zip
13:10:46,128 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bomber%20Man%202.zip to Bomber Man 2.zip
13:10:46,143 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bomberman_2_rom.zip to Bomberman_2_rom.zip
13:10:46,144 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bonk%27s%20Adventure.zip to Bonk's Adventure.zip
13:10:46,156 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Booby%20Kids.zip to Booby Kids.zip
13:10:46,166 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Boulder%20Dash.zip to Boulder Dash.zip
13:10:46,177 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bram%20Stoker%27s%20Dracula.zip to Bram Stoker's Dracula.zip
13:10:46,187 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Break%20Thru.zip to Break Thru.zip
13:10:46,198 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/BreakTime%20Pool.zip to BreakTime Pool.zip
13:10:46,209 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Brush%20Roller.zip to Brush Roller.zip
13:10:46,220 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bubble%20Bath%20Babes.zip to Bubble Bath Babes.zip
13:10:46,231 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bubble%20Bobble%201.zip to Bubble Bobble 1.zip
13:10:46,242 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bubble%20Bobble%202.zip to Bubble Bobble 2.zip
13:10:46,255 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bucky%20O%27Hare.zip to Bucky O'Hare.zip
13:10:46,265 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bugs%20Bunny%27s%20Birthday%20Bash.zip to Bugs Bunny's Birthday Bash.zip
13:10:46,276 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bugs%20Bunny%27s%20Crazy%20Castle.zip to Bugs Bunny's Crazy Castle.zip
13:10:46,286 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Bumb%20N%20Jump.zip to Bumb N Jump.zip
13:10:46,296 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Burai%20Fighter.zip to Burai Fighter.zip
13:10:46,306 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Burger%20Time.zip to Burger Time.zip
13:10:46,316 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Cabal.zip to Cabal.zip
13:10:46,326 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Caesars%20Palace.zip to Caesars Palace.zip
13:10:46,337 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/California%20Games.zip to California Games.zip
13:10:46,352 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Caltron%27s%206in1%20Games.zip to Caltron's 6in1 Games.zip
13:10:46,362 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Captain%20America%20%26%20the%20Advengers.zip to Captain America & the Advengers.zip
13:10:46,372 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Captain%20Planet%20%26%20the%20planteers.zip to Captain Planet & the planteers.zip
13:10:46,386 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Captain%20Skyhawk.zip to Captain Skyhawk.zip
13:10:46,394 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Casino%20Kid%201.zip to Casino Kid 1.zip
13:10:46,413 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Casino%20Kid%202.zip to Casino Kid 2.zip
13:10:46,423 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Castelian.zip to Castelian.zip
13:10:46,433 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Castle%20Excellant.zip to Castle Excellant.zip
13:10:46,448 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Castle%20of%20Deceit.zip to Castle of Deceit.zip
13:10:46,764 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Castle%20of%20Dragon.zip to Castle of Dragon.zip
13:10:46,863 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Castlevania%201.zip to Castlevania 1.zip
13:10:47,297 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Castlevania%202.zip to Castlevania 2.zip
13:10:47,839 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Castlevania%203.zip to Castlevania 3.zip
13:10:48,839 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Castlevania_rom.zip to Castlevania_rom.zip
13:10:49,210 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Caveman%20Games.zip to Caveman Games.zip
13:10:49,336 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Chack%20%26%20Pop.zip to Chack & Pop.zip
13:10:49,598 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Challenge%20%20Pebble%20Beach.zip to Challenge  Pebble Beach.zip
13:10:49,778 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Challenge%20of%20the%20Dragon.zip to Challenge of the Dragon.zip
13:10:49,852 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Challenger.zip to Challenger.zip
13:10:49,955 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Championship%20Bowling.zip to Championship Bowling.zip
13:10:50,327 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Championship%20Loderunner.zip to Championship Loderunner.zip
13:10:50,475 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Championship%20Pool.zip to Championship Pool.zip
13:10:50,945 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Chaos%20World.zip to Chaos World.zip
13:10:50,984 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Cheetah%20Men%202.zip to Cheetah Men 2.zip
13:10:51,203 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Chiller.zip to Chiller.zip
13:10:51,248 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Chip%20%26%20Dale%201.zip to Chip & Dale 1.zip
13:10:51,384 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Chip%20%26%20Dale%202.zip to Chip & Dale 2.zip
13:10:51,609 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Choujin%20Sentai%20-Jetman.zip to Choujin Sentai -Jetman.zip
13:10:51,755 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Chronicle%20of%20the%20Radia%20War.zip to Chronicle of the Radia War.zip
13:10:52,140 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Chubby%20Cherub.zip to Chubby Cherub.zip
13:10:52,250 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Chuka%20Taisen.zip to Chuka Taisen.zip
13:10:52,678 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Circus%20Caper.zip to Circus Caper.zip
13:10:52,679 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Circus%20Charlie.zip to Circus Charlie.zip
13:10:53,018 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/City%20Connection.zip to City Connection.zip
13:10:53,114 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Clash%20at%20Demon%20Head.zip to Clash at Demon Head.zip
13:10:53,140 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Classic%20Concentration.zip to Classic Concentration.zip
13:10:53,630 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Cliffhanger.zip to Cliffhanger.zip
13:10:53,780 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Clu%20Clu%20Land.zip to Clu Clu Land.zip
13:10:53,980 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Cobra%20Command.zip to Cobra Command.zip
13:10:54,226 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Cobra%20Triangle.zip to Cobra Triangle.zip
13:10:54,351 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Cobra.zip to Cobra.zip
13:10:54,669 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Cocoron.zip to Cocoron.zip
13:10:54,914 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Codename%20Viper.zip to Codename Viper.zip
13:10:54,974 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Color%20a%20Dinosaur.zip to Color a Dinosaur.zip
13:10:55,308 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Comics.zip to Comics.zip
13:10:55,455 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Commando.zip to Commando.zip
13:10:55,493 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Conan.zip to Conan.zip
13:10:55,847 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Conflict.zip to Conflict.zip
13:10:55,863 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Conquest%20of%20the%20Crystal%20Palace.zip to Conquest of the Crystal Palace.zip
13:10:56,186 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Contra%201.zip to Contra 1.zip
13:10:56,294 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Contra%202.zip to Contra 2.zip
13:10:56,444 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Contra%20Force.zip to Contra Force.zip
13:10:56,547 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Cool%20Spot%20the%207-Up%20Game.zip to Cool Spot the 7-Up Game.zip
13:10:56,688 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Cool%20World.zip to Cool World.zip
13:10:56,945 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Cosmo%20Genesis.zip to Cosmo Genesis.zip
13:10:57,006 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Cosmo%20Police.zip to Cosmo Police.zip
13:10:57,222 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Cowboy%20Kid.zip to Cowboy Kid.zip
13:10:57,280 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Crack%20Out.zip to Crack Out.zip
13:10:57,356 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Crash%20n%20the%20Boys%20Street%20Challenge.zip to Crash n the Boys Street Challenge.zip
13:10:57,397 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Crazy%20Climber.zip to Crazy Climber.zip
13:10:57,530 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Crystal%20Mines.zip to Crystal Mines.zip
13:10:57,827 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Crystalis.zip to Crystalis.zip
13:10:57,866 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Cyber%20Ball.zip to Cyber Ball.zip
13:10:58,074 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Cybernoid.zip to Cybernoid.zip
13:10:58,132 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Cyborg%20Mario.zip to Cyborg Mario.zip
13:10:58,458 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Danny%20Sullivan%27s%20Indy%20Heat.zip to Danny Sullivan's Indy Heat.zip
13:10:58,528 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Darkman.zip to Darkman.zip
13:10:58,605 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Darkwing%20Duck.zip to Darkwing Duck.zip
13:10:58,813 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dash%20Galaxy.zip to Dash Galaxy.zip
13:10:58,901 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Day%20Dreamin%20Dave.zip to Day Dreamin Dave.zip
13:10:58,978 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Days%20of%20Thunder.zip to Days of Thunder.zip
13:10:59,354 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/De%20Ja%20vu.zip to De Ja vu.zip
13:10:59,470 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Deadly%20Towers.zip to Deadly Towers.zip
13:10:59,795 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Deep%20Dungeon%204.zip to Deep Dungeon 4.zip
13:10:59,817 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Defender%202.zip to Defender 2.zip
13:10:59,939 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Defender%20of%20the%20Crown.zip to Defender of the Crown.zip
13:10:59,999 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Defender%20of%20the%20Dynatron%20City.zip to Defender of the Dynatron City.zip
13:11:00,059 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Demon%20Sword.zip to Demon Sword.zip
13:11:00,142 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Desert%20Commander.zip to Desert Commander.zip
13:11:00,197 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Destination%20Earthstar.zip to Destination Earthstar.zip
13:11:00,728 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Destiny%20of%20an%20Emperor%201.zip to Destiny of an Emperor 1.zip
13:11:00,949 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Destiny%20of%20an%20Emperor%202.zip to Destiny of an Emperor 2.zip
13:11:01,234 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Devil%20World.zip to Devil World.zip
13:11:01,703 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dezaemon.zip to Dezaemon.zip
13:11:01,873 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dick%20Tracy.zip to Dick Tracy.zip
13:11:02,261 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Die%20Hard.zip to Die Hard.zip
13:11:02,392 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dig%20Dug.zip to Dig Dug.zip
13:11:02,733 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Digger.zip to Digger.zip
13:11:02,852 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dirty%20Harry.zip to Dirty Harry.zip
13:11:03,241 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dizzy%20the%20Adverturer.zip to Dizzy the Adverturer.zip
13:11:03,363 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dog%20Town.zip to Dog Town.zip
13:11:03,795 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Doki%21%20Doki%21%20Amusement%20Park.zip to Doki! Doki! Amusement Park.zip
13:11:03,868 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Donald%20Duck.zip to Donald Duck.zip
13:11:04,317 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Donkey%20Kong%201.zip to Donkey Kong 1.zip
13:11:04,556 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Donkey%20Kong%203.zip to Donkey Kong 3.zip
13:11:05,045 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Donkey%20Kong%20Classics.zip to Donkey Kong Classics.zip
13:11:05,047 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Donkey%20Kong%20Jr%20Math.zip to Donkey Kong Jr Math.zip
13:11:05,170 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Donkey%20Kong%20Jr.zip to Donkey Kong Jr.zip
13:11:05,292 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Donkey_Kong_3_rom.zip to Donkey_Kong_3_rom.zip
13:11:05,315 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Door%20Door.zip to Door Door.zip
13:11:05,459 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Doraemon.zip to Doraemon.zip
13:11:05,983 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Double%20Dare.zip to Double Dare.zip
13:11:06,082 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Double%20Dragon%201.zip to Double Dragon 1.zip
13:11:06,184 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Double%20Dragon%202.zip to Double Dragon 2.zip
13:11:06,437 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Double%20Dragon%203.zip to Double Dragon 3.zip
13:11:06,605 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Double%20Dribble.zip to Double Dribble.zip
13:11:06,701 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Double%20Strike.zip to Double Strike.zip
13:11:07,095 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dr%20Mario.zip to Dr Mario.zip
13:11:07,619 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dr.%20Chaos.zip to Dr. Chaos.zip
13:11:07,671 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dr.%20Jekyll%20%20and%20Mr%20%20Hyde.zip to Dr. Jekyll  and Mr  Hyde.zip
13:11:08,070 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dr_Mario_rom.zip to Dr_Mario_rom.zip
13:11:08,092 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dragon%20Fighter.zip to Dragon Fighter.zip
13:11:08,269 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dragon%20Power.zip to Dragon Power.zip
13:11:08,465 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dragon%20Spirit.zip to Dragon Spirit.zip
13:11:08,590 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dragon%20Strike.zip to Dragon Strike.zip
13:11:08,749 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dragon%20Warrior%201.zip to Dragon Warrior 1.zip
13:11:08,825 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dragon%20Warrior%202.zip to Dragon Warrior 2.zip
13:11:08,992 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dragon%20Warrior%203.zip to Dragon Warrior 3.zip
13:11:09,002 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dragon%20Warrior%204.zip to Dragon Warrior 4.zip
13:11:09,401 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dragonball.zip to Dragonball.zip
13:11:09,432 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dragons%20Lair.zip to Dragons Lair.zip
13:11:09,768 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Duck%20Hunt.zip to Duck Hunt.zip
13:11:09,784 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Ducktales%201.zip to Ducktales 1.zip
13:11:09,884 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Ducktales%202.zip to Ducktales 2.zip
13:11:10,019 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dudes%20with%20Attitude.zip to Dudes with Attitude.zip
13:11:10,164 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dungon%20Magic.zip to Dungon Magic.zip
13:11:10,334 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dusty%20Diamond%27s%20All%20Star%20Softball.zip to Dusty Diamond's All Star Softball.zip
13:11:10,496 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Dynowarz.zip to Dynowarz.zip
13:11:10,570 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Earth%20Bound%20Zero.zip to Earth Bound Zero.zip
13:11:10,728 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Elevator%20Action.zip to Elevator Action.zip
13:11:10,850 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Eliminator%20Boat%20Duel.zip to Eliminator Boat Duel.zip
13:11:11,096 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Elite.zip to Elite.zip
13:11:11,199 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Elrong.zip to Elrong.zip
13:11:11,600 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Evert%20%26%20Lendl%20Top%20Plyers%20Tennis.zip to Evert & Lendl Top Plyers Tennis.zip
13:11:11,624 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Excite%20Bike.zip to Excite Bike.zip
13:11:11,813 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Exodus.zip to Exodus.zip
13:11:11,931 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/F-117A%20Stealth%20Fightert.zip to F-117A Stealth Fightert.zip
13:11:11,941 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/F-15%20City%20War.zip to F-15 City War.zip
13:11:12,144 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/F-15%20Strike%20Eagle.zip to F-15 Strike Eagle.zip
13:11:12,274 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Family%20Feud.zip to Family Feud.zip
13:11:12,579 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Fantasy%20Zone.zip to Fantasy Zone.zip
13:11:12,797 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Faria.zip to Faria.zip
13:11:12,980 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Faxanadu.zip to Faxanadu.zip
13:11:13,013 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Felix%20the%20Cat.zip to Felix the Cat.zip
13:11:13,145 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Ferrari%20Grand%20Prix%20Challenge.zip to Ferrari Grand Prix Challenge.zip
13:11:13,278 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Final%20Fantasy%201.zip to Final Fantasy 1.zip
13:11:13,465 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Final%20Fantasy%202.zip to Final Fantasy 2.zip
13:11:13,604 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Final%20Fantasy%203%20%28Sound%29.zip to Final Fantasy 3 (Sound).zip
13:11:13,948 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Fire%20Bird.zip to Fire Bird.zip
13:11:13,964 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Fire%20Emblem%20Gaiden.zip to Fire Emblem Gaiden.zip
13:11:14,445 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Fire%20n%20Ice.zip to Fire n Ice.zip
13:11:14,516 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/FisherPrice%20Firehouse%20Rescue.zip to FisherPrice Firehouse Rescue.zip
13:11:14,837 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/FisherPrice%20I%20Can%20Remember.zip to FisherPrice I Can Remember.zip
13:11:14,912 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/FisherPrice%20Perfect%20Fit.zip to FisherPrice Perfect Fit.zip
13:11:15,070 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Fist%20of%20the%20North%20Star.zip to Fist of the North Star.zip
13:11:15,181 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Fist%20of%20Thor.zip to Fist of Thor.zip
13:11:15,258 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Flight%20of%20the%20Intruder.zip to Flight of the Intruder.zip
13:11:15,341 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Flintstones%20Rescue%20of%20Dino%20%26%20Hoppy.zip to Flintstones Rescue of Dino & Hoppy.zip
13:11:15,490 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Flintstones%20Suppise%20at%20Dinosaur%20Peak.zip to Flintstones Suppise at Dinosaur Peak.zip
13:11:16,035 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Flipull.zip to Flipull.zip
13:11:16,213 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Flying%20Dragon.zip to Flying Dragon.zip
13:11:16,296 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Flying%20Warriors.zip to Flying Warriors.zip
13:11:16,586 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Formula%20-1%20Built%20to%20Win.zip to Formula -1 Built to Win.zip
13:11:17,068 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Frankenstein.zip to Frankenstein.zip
13:11:17,163 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Freedom%20Force.zip to Freedom Force.zip
13:11:17,181 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Friday%20the%2013th.zip to Friday the 13th.zip
13:11:17,325 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Front%20Line.zip to Front Line.zip
13:11:17,461 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Fun%20House.zip to Fun House.zip
13:11:17,480 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Future%20Soldier%20Lois.zip to Future Soldier Lois.zip
13:11:17,601 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Fuzzical%20Fighter.zip to Fuzzical Fighter.zip
13:11:17,623 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/G.I.Joe%20Atlantise%20Factor.zip to G.I.Joe Atlantise Factor.zip
13:11:17,882 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/G.I.Joe.zip to G.I.Joe.zip
13:11:18,319 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Galactic%20Crusader.zip to Galactic Crusader.zip
13:11:18,351 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Galaga.zip to Galaga.zip
13:11:18,476 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Galaxian.zip to Galaxian.zip
13:11:18,484 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Ganbare%20Goemon%21.zip to Ganbare Goemon!.zip
13:11:18,980 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Garfield.zip to Garfield.zip
13:11:18,988 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Gargon.zip to Gargon.zip
13:11:19,227 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Gargqoyle%27s%20Quest%202.zip to Gargqoyle's Quest 2.zip
13:11:19,538 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Gauntlet%201.zip to Gauntlet 1.zip
13:11:19,781 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Gauntlet%202.zip to Gauntlet 2.zip
13:11:19,907 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Gemfire.zip to Gemfire.zip
13:11:19,916 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Genghis%20Khan.zip to Genghis Khan.zip
13:11:20,048 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/George%20Foreman%27s%20KO%20Boxing.zip to George Foreman's KO Boxing.zip
13:11:20,486 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Get%20Sumri%20Fuuma%20Densetsu.zip to Get Sumri Fuuma Densetsu.zip
13:11:20,514 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Ghost%20Busters%201.zip to Ghost Busters 1.zip
13:11:20,705 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Ghost%20Busters%202.zip to Ghost Busters 2.zip
13:11:20,776 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Ghosts%20n%20Goblins.zip to Ghosts n Goblins.zip
13:11:21,056 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Ghoul%20School.zip to Ghoul School.zip
13:11:21,079 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Glory%20of%20Heracles%202.zip to Glory of Heracles 2.zip
13:11:21,463 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Goal%21%201.zip to Goal! 1.zip
13:11:21,670 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Goal%21%202.zip to Goal! 2.zip
13:11:21,858 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Godzilla%201.zip to Godzilla 1.zip
13:11:21,917 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Godzilla%202.zip to Godzilla 2.zip
13:11:22,055 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Gold%20Medal%20Challenge%2092.zip to Gold Medal Challenge 92.zip
13:11:22,145 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Golf%20Challenge%20Peble%20Beach.zip to Golf Challenge Peble Beach.zip
13:11:22,334 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Golf%20Grand%20Slam.zip to Golf Grand Slam.zip
13:11:22,514 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Golf.zip to Golf.zip
13:11:22,797 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Golgo13.zip to Golgo13.zip
13:11:22,842 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Goonie%201.zip to Goonie 1.zip
13:11:23,085 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Goonies%202.zip to Goonies 2.zip
13:11:23,243 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Gotcha%21.zip to Gotcha!.zip
13:11:23,521 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Gradius.zip to Gradius.zip
13:11:23,571 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Greg%20Norman%27s%20Golf%20Power.zip to Greg Norman's Golf Power.zip
13:11:23,691 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Gremlins%202.zip to Gremlins 2.zip
13:11:23,973 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Gryzor.zip to Gryzor.zip
13:11:24,273 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Guerilla%20War.zip to Guerilla War.zip
13:11:24,514 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Gumshoe.zip to Gumshoe.zip
13:11:24,764 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Gun%20Nac.zip to Gun Nac.zip
13:11:24,955 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Gun%20Smoke.zip to Gun Smoke.zip
13:11:25,134 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Gyromite.zip to Gyromite.zip
13:11:25,458 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Gyruss.zip to Gyruss.zip
13:11:25,634 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Haloween%20%28Sound%29.zip to Haloween (Sound).zip
13:11:25,676 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Harlem%20Globe%20Trotters.zip to Harlem Globe Trotters.zip
13:11:25,788 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Hatris.zip to Hatris.zip
13:11:25,960 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Heavy%20Barrel.zip to Heavy Barrel.zip
13:11:26,241 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Heavy%20Shredoin.zip to Heavy Shredoin.zip
13:11:26,404 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/HelloKitty%20World.zip to HelloKitty World.zip
13:11:26,478 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/HelloKitty%27s%20Flower%20Shop.zip to HelloKitty's Flower Shop.zip
13:11:27,070 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/HighSpeed.zip to HighSpeed.zip
13:11:27,084 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Hogans%20Alley.zip to Hogans Alley.zip
13:11:27,480 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Hollywood%20Squares.zip to Hollywood Squares.zip
13:11:27,545 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Home%20Alone%201.zip to Home Alone 1.zip
13:11:27,698 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Home%20Alone%202.zip to Home Alone 2.zip
13:11:27,780 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Homerun%2090.zip to Homerun 90.zip
13:11:28,140 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Hook.zip to Hook.zip
13:11:28,310 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Hoops.zip to Hoops.zip
13:11:28,527 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Hot%20Slot.zip to Hot Slot.zip
13:11:28,598 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Hotman.zip to Hotman.zip
13:11:28,695 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Hudson%20Hawk.zip to Hudson Hawk.zip
13:11:29,130 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Hydlide.zip to Hydlide.zip
13:11:29,265 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Ice%20Climber.zip to Ice Climber.zip
13:11:29,573 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Ice%20Hockey.zip to Ice Hockey.zip
13:11:29,681 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Ikari%20Warriors%201.zip to Ikari Warriors 1.zip
13:11:29,849 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Ikari%20Warriors%202.zip to Ikari Warriors 2.zip
13:11:29,984 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Ikari%20Warriors%203.zip to Ikari Warriors 3.zip
13:11:30,068 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Image%20Fight.zip to Image Fight.zip
13:11:30,282 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Impossible%20Mission%202.zip to Impossible Mission 2.zip
13:11:30,926 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Incredible%20Crash%20Dummies.zip to Incredible Crash Dummies.zip
13:11:30,996 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Indiana%20Jones%20Last%20Crusades.zip to Indiana Jones Last Crusades.zip
13:11:31,051 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Indiana%20Jones%20Temple%20of%20Doom.zip to Indiana Jones Temple of Doom.zip
13:11:31,481 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Infiltrator.zip to Infiltrator.zip
13:11:31,492 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Irontank.zip to Irontank.zip
13:11:31,606 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Isolated%20Warrior.zip to Isolated Warrior.zip
13:11:31,629 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/IvanStreward%27sSuper%20Off%20Road.zip to IvanStreward'sSuper Off Road.zip
13:11:31,758 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Jack%20Nicklaus%20Golf.zip to Jack Nicklaus Golf.zip
13:11:31,775 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Jackal.zip to Jackal.zip
13:11:31,877 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Jackie%20Chan.zip to Jackie Chan.zip
13:11:31,899 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/James%20Bond%20Jr.zip to James Bond Jr.zip
13:11:31,990 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Jaws.zip to Jaws.zip
13:11:32,407 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Jeopardy%2025th%20Anniversary.zip to Jeopardy 25th Anniversary.zip
13:11:32,553 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Jeopardy%20Jr.zip to Jeopardy Jr.zip
13:11:32,885 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Jeopardy.zip to Jeopardy.zip
13:11:33,028 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Jetsons%20Cogswell%27s%20Caper.zip to Jetsons Cogswell's Caper.zip
13:11:33,402 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Jim%20Conner%27s%20Tennis.zip to Jim Conner's Tennis.zip
13:11:33,412 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Joe%20%26%20Mac.zip to Joe & Mac.zip
13:11:33,557 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/John%20Elway%27s%20Quarterback.zip to John Elway's Quarterback.zip
13:11:33,797 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Jordan%20vs%20Bird%20One%20on%20One.zip to Jordan vs Bird One on One.zip
13:11:33,837 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Joshua.zip to Joshua.zip
13:11:34,091 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Journey%20to%20Silius.zip to Journey to Silius.zip
13:11:34,228 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Joust.zip to Joust.zip
13:11:34,504 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Joy%20Mech%20Fight.zip to Joy Mech Fight.zip
13:11:34,573 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Jungle%20Book.zip to Jungle Book.zip
13:11:35,002 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Jurassic%20Park%201.zip to Jurassic Park 1.zip
13:11:35,179 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Kabuki%20Quantum%20Fighter.zip to Kabuki Quantum Fighter.zip
13:11:35,223 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Karate%20Champship.zip to Karate Champship.zip
13:11:35,641 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Karate%20Kid.zip to Karate Kid.zip
13:11:36,090 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Karnov.zip to Karnov.zip
13:11:36,652 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Kart%20Fighter.zip to Kart Fighter.zip
13:11:36,900 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/KeroKero%20Keroppis%20Big%20Adventure%201.zip to KeroKero Keroppis Big Adventure 1.zip
13:11:37,401 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/KeroKero%20Keroppis%20Great%20Big%20Adventure%202.zip to KeroKero Keroppis Great Big Adventure 2.zip
13:11:37,784 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Keroppi%20%26%20Keroleens%20Splash%20Bomb%21.zip to Keroppi & Keroleens Splash Bomb!.zip
13:11:38,091 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Kick%20Master.zip to Kick Master.zip
13:11:38,130 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Kickle%20Cubicle.zip to Kickle Cubicle.zip
13:11:38,262 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Kid%20Icarus.zip to Kid Icarus.zip
13:11:38,397 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Kid%20Klown.zip to Kid Klown.zip
13:11:38,678 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Kid%20Kool.zip to Kid Kool.zip
13:11:38,713 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Kid%20Niki%201.zip to Kid Niki 1.zip
13:11:38,915 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Kid%20Niki%202.zip to Kid Niki 2.zip
13:11:39,388 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/King%20of%20Kings.zip to King of Kings.zip
13:11:39,399 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/KingNeptunesAdventure.zip to KingNeptunesAdventure.zip
13:11:39,702 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Kings%20Knight.zip to Kings Knight.zip
13:11:39,748 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Kings%20of%20the%20Beach.zip to Kings of the Beach.zip
13:11:39,922 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/King%27s%20Quest%205.zip to King's Quest 5.zip
13:11:40,128 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Kirby%27s%20Adventure.zip to Kirby's Adventure.zip
13:11:40,298 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Kiwi%20Kraze.zip to Kiwi Kraze.zip
13:11:40,484 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Klash%20Ball.zip to Klash Ball.zip
13:11:40,775 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Klax.zip to Klax.zip
13:11:40,947 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Knight%20Rider.zip to Knight Rider.zip
13:11:41,126 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Krazy%20Kreatures.zip to Krazy Kreatures.zip
13:11:41,196 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Krion%20Conquest.zip to Krion Conquest.zip
13:11:41,630 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Krusty%27s%20Fun%20House.zip to Krusty's Fun House.zip
13:11:41,693 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Kung%20Fu%20HeroS.zip to Kung Fu HeroS.zip
13:11:41,828 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Kung%20Fu.zip to Kung Fu.zip
13:11:42,120 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Laser%20Invasion.zip to Laser Invasion.zip
13:11:42,345 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Last%20ActionHero.zip to Last ActionHero.zip
13:11:42,546 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Last%20Ninj.zip to Last Ninj.zip
13:11:42,668 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Lee%20Treuino%27s%20Fighting%20Golf.zip to Lee Treuino's Fighting Golf.zip
13:11:42,942 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Legacy%20of%20the%20Wizard.zip to Legacy of the Wizard.zip
13:11:43,430 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Legend%20of%20Kage.zip to Legend of Kage.zip
13:11:43,544 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Legend%20of%20the%20Ghost%20Lion.zip to Legend of the Ghost Lion.zip
13:11:43,575 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Legendary%20Wings.zip to Legendary Wings.zip
13:11:43,679 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Lemmings.zip to Lemmings.zip
13:11:43,931 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/L%27Empereur.zip to L'Empereur.zip
13:11:43,942 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Lethal%20Weapon.zip to Lethal Weapon.zip
13:11:44,085 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Lifeforce.zip to Lifeforce.zip
13:11:44,246 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Linus%20Space%20Head.zip to Linus Space Head.zip
13:11:44,362 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Little%20Mermaid.zip to Little Mermaid.zip
13:11:44,534 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Little%20Nemo%20Dream%20Master.zip to Little Nemo Dream Master.zip
13:11:44,764 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Little%20Ninja%20Brothers.zip to Little Ninja Brothers.zip
13:11:44,827 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Little%20Samson.zip to Little Samson.zip
13:11:45,288 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Littlle%20League%20Baseball.zip to Littlle League Baseball.zip
13:11:45,323 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Lode%20Runner.zip to Lode Runner.zip
13:11:45,698 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Loopz.zip to Loopz.zip
13:11:45,821 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Low%20G%20Man.zip to Low G Man.zip
13:11:45,876 INFO  [DownloadRunner] downloading http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/Lunar%20Pool.zip to Lunar Pool.zip
```