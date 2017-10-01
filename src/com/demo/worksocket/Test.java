package com.demo.worksocket;

public class Test {
public static void main(String[] args) {
	 TaskTimer task=new TaskTimer();
   
     task.schedule(new task(), 1000, 1000);
}
}
