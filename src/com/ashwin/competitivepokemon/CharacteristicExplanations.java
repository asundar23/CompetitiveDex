package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
public class CharacteristicExplanations {
	
	String name;
	String[] characteristics;
	
	public CharacteristicExplanations(String n,String[] allCharacteristics){
		name = n;;
		characteristics = allCharacteristics;
		explanations();
	}
	
	public String explanations(){
		
		String n = "";
		
		if(name.equals(characteristics[0])){
			n = "Highest stat is <font color='#B84DB8'>HP</font>. Possible <font color='#B84DB8'>HP</font> IV's are: <font color='#FFEBFF'>0</font>, <font color='#FFE6FF'>5</font>, <font color='#FFCCFF'>10</font>, <font color='#FFB8FF'>15</font>, <font color='#FF83FF'>20</font>, <font color='#FF19FF'>25</font>, and <font color='#CC14CC'>30</font>.";
		}
		if(name.equals(characteristics[1])){
			n = "Highest stat is <font color='#B84DB8'>HP</font>. Possible <font color='#B84DB8'>HP</font> IV's are: <font color='#FFEBFF'>1</font>, <font color='#FFE6FF'>6</font>, <font color='#FFCCFF'>11</font>, <font color='#FFB8FF'>16</font>, <font color='#FF83FF'>21</font>, <font color='#FF19FF'>26</font>, and <font color='#CC14CC'>31</font>.";
		}
		if(name.equals(characteristics[2])){
			n = "Highest stat is <font color='#B84DB8'>HP</font>. Possible <font color='#B84DB8'>HP</font> IV's are: <font color='#FFEBFF'>2</font>, <font color='#FFE6FF'>7</font>, <font color='#FFCCFF'>12</font>, <font color='#FFB8FF'>17</font>, <font color='#FF83FF'>22</font>, <font color='#FF19FF'>27</font>.";
		}
		if(name.equals(characteristics[3])){
			n = "Highest stat is <font color='#B84DB8'>HP</font>. Possible <font color='#B84DB8'>HP</font> IV's are: <font color='#FFEBFF'>3</font>, <font color='#FFE6FF'>8</font>, <font color='#FFCCFF'>13</font>, <font color='#FFB8FF'>18</font>, <font color='#FF83FF'>23</font>, <font color='#FF19FF'>28</font>.";
		}
		if(name.equals(characteristics[4])){
			n = "Highest stat is <font color='#B84DB8'>HP</font>. Possible <font color='#B84DB8'>HP</font> IV's are: <font color='#FFEBFF'>4</font>, <font color='#FFE6FF'>9</font>, <font color='#FFCCFF'>14</font>, <font color='#FFB8FF'>19</font>, <font color='#FF83FF'>24</font>, <font color='#FF19FF'>29</font>.";
		}
		
		
		if(name.equals(characteristics[5])){
			n = "Highest stat is <font color='#B84DB8'>Attack</font>. Possible <font color='#B84DB8'>Attack</font> IV's are: <font color='#FFEBFF'>0</font>, <font color='#FFE6FF'>5</font>, <font color='#FFCCFF'>10</font>, <font color='#FFB8FF'>15</font>, <font color='#FF83FF'>20</font>, <font color='#FF19FF'>25</font>, and <font color='#CC14CC'>30</font>.";
		}
		if(name.equals(characteristics[6])){
			n = "Highest stat is <font color='#B84DB8'>Attack</font>. Possible <font color='#B84DB8'>Attack</font> IV's are: <font color='#FFEBFF'>1</font>, <font color='#FFE6FF'>6</font>, <font color='#FFCCFF'>11</font>, <font color='#FFB8FF'>16</font>, <font color='#FF83FF'>21</font>, <font color='#FF19FF'>26</font>, and <font color='#CC14CC'>31</font>.";
		}
		if(name.equals(characteristics[7])){
			n = "Highest stat is <font color='#B84DB8'>Attack</font>. Possible <font color='#B84DB8'>Attack</font> IV's are: <font color='#FFEBFF'>2</font>, <font color='#FFE6FF'>7</font>, <font color='#FFCCFF'>12</font>, <font color='#FFB8FF'>17</font>, <font color='#FF83FF'>22</font>, <font color='#FF19FF'>27</font>.";
		}
		if(name.equals(characteristics[8])){
			n = "Highest stat is <font color='#B84DB8'>Attack</font>. Possible <font color='#B84DB8'>Attack</font> IV's are: <font color='#FFEBFF'>3</font>, <font color='#FFE6FF'>8</font>, <font color='#FFCCFF'>13</font>, <font color='#FFB8FF'>18</font>, <font color='#FF83FF'>23</font>, <font color='#FF19FF'>28</font>.";
		}
		if(name.equals(characteristics[9])){
			n = "Highest stat is <font color='#B84DB8'>Attack</font>. Possible <font color='#B84DB8'>Attack</font> IV's are: <font color='#FFEBFF'>4</font>, <font color='#FFE6FF'>9</font>, <font color='#FFCCFF'>14</font>, <font color='#FFB8FF'>19</font>, <font color='#FF83FF'>24</font>, <font color='#FF19FF'>29</font>.";
		}
		
		
		if(name.equals(characteristics[10])){
			n = "Highest stat is <font color='#B84DB8'>Defense</font>. Possible <font color='#B84DB8'>Defense</font> IV's are: <font color='#FFEBFF'>0</font>, <font color='#FFE6FF'>5</font>, <font color='#FFCCFF'>10</font>, <font color='#FFB8FF'>15</font>, <font color='#FF83FF'>20</font>, <font color='#FF19FF'>25</font>, and <font color='#CC14CC'>30</font>.";
		}
		if(name.equals(characteristics[11])){
			n = "Highest stat is <font color='#B84DB8'>Defense</font>. Possible <font color='#B84DB8'>Defense</font> IV's are: <font color='#FFEBFF'>1</font>, <font color='#FFE6FF'>6</font>, <font color='#FFCCFF'>11</font>, <font color='#FFB8FF'>16</font>, <font color='#FF83FF'>21</font>, <font color='#FF19FF'>26</font>, and <font color='#CC14CC'>31</font>.";
		}
		if(name.equals(characteristics[12])){
			n = "Highest stat is <font color='#B84DB8'>Defense</font>. Possible <font color='#B84DB8'>Defense</font> IV's are: <font color='#FFEBFF'>2</font>, <font color='#FFE6FF'>7</font>, <font color='#FFCCFF'>12</font>, <font color='#FFB8FF'>17</font>, <font color='#FF83FF'>22</font>, <font color='#FF19FF'>27</font>.";
		}
		if(name.equals(characteristics[13])){
			n = "Highest stat is <font color='#B84DB8'>Defense</font>. Possible <font color='#B84DB8'>Defense</font> IV's are: <font color='#FFEBFF'>3</font>, <font color='#FFE6FF'>8</font>, <font color='#FFCCFF'>13</font>, <font color='#FFB8FF'>18</font>, <font color='#FF83FF'>23</font>, <font color='#FF19FF'>28</font>.";
		}
		if(name.equals(characteristics[14])){
			n = "Highest stat is <font color='#B84DB8'>Defense</font>. Possible <font color='#B84DB8'>Defense</font> IV's are: <font color='#FFEBFF'>4</font>, <font color='#FFE6FF'>9</font>, <font color='#FFCCFF'>14</font>, <font color='#FFB8FF'>19</font>, <font color='#FF83FF'>24</font>, <font color='#FF19FF'>29</font>.";
		}
		
		
		if(name.equals(characteristics[15])){
			n = "Highest stat is <font color='#B84DB8'>Special Attack</font>. Possible <font color='#B84DB8'>Special Attack</font> IV's are: <font color='#FFEBFF'>0</font>, <font color='#FFE6FF'>5</font>, <font color='#FFCCFF'>10</font>" +
					", <font color='#FFB8FF'>15</font>, <font color='#FF83FF'>20</font>, " +
					"<font color='#FF19FF'>25</font>, and <font color='#CC14CC'>30</font>.";
		}
		if(name.equals(characteristics[16])){
			n = "Highest stat is <font color='#B84DB8'>Special Attack</font>. Possible <font color='#B84DB8'>Special Attack</font> IV's are: <font color='#FFEBFF'>1</font>, <font color='#FFE6FF'>6</font>, <font color='#FFCCFF'>11</font>, <font color='#FFB8FF'>16</font>, <font color='#FF83FF'>21</font>, <font color='#FF19FF'>26</font>, and <font color='#CC14CC'>31</font>.";
		}
		if(name.equals(characteristics[17])){
			n = "Highest stat is <font color='#B84DB8'>Special Attack</font>. Possible <font color='#B84DB8'>Special Attack</font> IV's are: <font color='#FFEBFF'>2</font>, <font color='#FFE6FF'>7</font>, <font color='#FFCCFF'>12</font>, <font color='#FFB8FF'>17</font>, <font color='#FF83FF'>22</font>, <font color='#FF19FF'>27</font>.";
		}
		if(name.equals(characteristics[18])){
			n = "Highest stat is <font color='#B84DB8'>Special Attack</font>. Possible <font color='#B84DB8'>Special Attack</font> IV's are: <font color='#FFEBFF'>3</font>, <font color='#FFE6FF'>8</font>, <font color='#FFCCFF'>13</font>, <font color='#FFB8FF'>18</font>, <font color='#FF83FF'>23</font>, <font color='#FF19FF'>28</font>.";
		}
		if(name.equals(characteristics[19])){
			n = "Highest stat is <font color='#B84DB8'>Special Attack</font>. Possible <font color='#B84DB8'>Special Attack</font> IV's are: <font color='#FFEBFF'>4</font>, <font color='#FFE6FF'>9</font>, <font color='#FFCCFF'>14</font>, <font color='#FFB8FF'>19</font>, <font color='#FF83FF'>24</font>, <font color='#FF19FF'>29</font>.";
		}
		
		
		if(name.equals(characteristics[20])){
			n = "Highest stat is <font color='#B84DB8'>Special Defense</font>. Possible <font color='#B84DB8'>Special Defense</font> IV's are: <font color='#FFEBFF'>0</font>, <font color='#FFE6FF'>5</font>, <font color='#FFCCFF'>10</font>, <font color='#FFB8FF'>15</font>, <font color='#FF83FF'>20</font>, <font color='#FF19FF'>25</font>, and <font color='#CC14CC'>30</font>.";
		}
		if(name.equals(characteristics[21])){
			n = "Highest stat is <font color='#B84DB8'>Special Defense</font>. Possible <font color='#B84DB8'>Special Defense</font> IV's are: <font color='#FFEBFF'>1</font>, <font color='#FFE6FF'>6</font>, <font color='#FFCCFF'>11</font>, <font color='#FFB8FF'>16</font>, <font color='#FF83FF'>21</font>, <font color='#FF19FF'>26</font>, and <font color='#CC14CC'>31</font>.";
		}
		if(name.equals(characteristics[22])){
			n = "Highest stat is <font color='#B84DB8'>Special Defense</font>. Possible <font color='#B84DB8'>Special Defense</font> IV's are: <font color='#FFEBFF'>2</font>, <font color='#FFE6FF'>7</font>, <font color='#FFCCFF'>12</font>, <font color='#FFB8FF'>17</font>, <font color='#FF83FF'>22</font>, <font color='#FF19FF'>27</font>.";
		}
		if(name.equals(characteristics[23])){
			n = "Highest stat is <font color='#B84DB8'>Special Defense</font>. Possible <font color='#B84DB8'>Special Defense</font> IV's are: <font color='#FFEBFF'>3</font>, <font color='#FFE6FF'>8</font>, <font color='#FFCCFF'>13</font>, <font color='#FFB8FF'>18</font>, <font color='#FF83FF'>23</font>, <font color='#FF19FF'>28</font>.";
		}
		if(name.equals(characteristics[24])){
			n = "Highest stat is <font color='#B84DB8'>Special Defense</font>. Possible <font color='#B84DB8'>Special Defense</font> IV's are: <font color='#FFEBFF'>4</font>, <font color='#FFE6FF'>9</font>, <font color='#FFCCFF'>14</font>, <font color='#FFB8FF'>19</font>, <font color='#FF83FF'>24</font>, <font color='#FF19FF'>29</font>.";
		}
		
		
		
		if(name.equals(characteristics[25])){
			n = "Highest stat is <font color='#B84DB8'>Speed</font>. Possible <font color='#B84DB8'>Speed</font> IV's are: <font color='#FFEBFF'>0</font>, <font color='#FFE6FF'>5</font>, <font color='#FFCCFF'>10</font>, <font color='#FFB8FF'>15</font>, <font color='#FF83FF'>20</font>, <font color='#FF19FF'>25</font>, and <font color='#CC14CC'>30</font>.";
		}
		if(name.equals(characteristics[26])){
			n = "Highest stat is <font color='#B84DB8'>Speed</font>. Possible <font color='#B84DB8'>Speed</font> IV's are: <font color='#FFEBFF'>1</font>, <font color='#FFE6FF'>6</font>, <font color='#FFCCFF'>11</font>, <font color='#FFB8FF'>16</font>, <font color='#FF83FF'>21</font>, <font color='#FF19FF'>26</font>, and <font color='#CC14CC'>31</font>.";
		}
		if(name.equals(characteristics[27])){
			n = "Highest stat is <font color='#B84DB8'>Speed</font>. Possible <font color='#B84DB8'>Speed</font> IV's are: <font color='#FFEBFF'>2</font>, <font color='#FFE6FF'>7</font>, <font color='#FFCCFF'>12</font>, <font color='#FFB8FF'>17</font>, <font color='#FF83FF'>22</font>, <font color='#FF19FF'>27</font>.";
		}
		if(name.equals(characteristics[28])){
			n = "Highest stat is <font color='#B84DB8'>Speed</font>. Possible <font color='#B84DB8'>Speed</font> IV's are: <font color='#FFEBFF'>3</font>, <font color='#FFE6FF'>8</font>, <font color='#FFCCFF'>13</font>, <font color='#FFB8FF'>18</font>, <font color='#FF83FF'>23</font>, <font color='#FF19FF'>28</font>.";
		}
		if(name.equals(characteristics[29])){
			n = "Highest stat is <font color='#B84DB8'>Speed</font>. Possible <font color='#B84DB8'>Speed</font> IV's are: <font color='#FFEBFF'>4</font>, <font color='#FFE6FF'>9</font>, <font color='#FFCCFF'>14</font>, <font color='#FFB8FF'>19</font>, <font color='#FF83FF'>24</font>, <font color='#FF19FF'>29</font>.";
		}
		
		return n;
	}

}
