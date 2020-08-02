package com.springproject;


public class PersonProfile {
		private String text;
		
		private String name;
		private int age;
		
		public PersonProfile() {
		}

		public PersonProfile(String text) {
			super();
			this.text = text;
		}

		@Override
		public String toString() {
			return "PersonProfile [text=" + text + "]";
		}
		


}
