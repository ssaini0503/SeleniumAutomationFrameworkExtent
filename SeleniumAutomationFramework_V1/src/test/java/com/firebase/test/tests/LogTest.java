package com.firebase.test.tests;


import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class LogTest{

   /* Get actual class name to be printed on */
   static Logger logger = Logger.getLogger(LogTest.class.getName());
   @Test
   public static void main(String[] args)throws IOException,SQLException
   {
	   logger.debug("Hello this is a debug message");
	   logger.info("Hello this is an info message");
	   logger.fatal("Hello this is a debug message");
	   logger.error("Hello this is a debug message");
   }
}