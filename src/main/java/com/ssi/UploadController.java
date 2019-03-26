package com.ssi;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
@Autowired
UserService userService;
@RequestMapping("/dataentry")
public String dataEntry(){
	return "dataentry";
}

@RequestMapping("/search")
public String openSearch(){
	return "search";
}

@RequestMapping(value="/viewall")
public ModelAndView allUser(){
	List<User> users=userService.getAllUsers();
	ModelAndView mv=new ModelAndView();	
	mv.addObject("users",users);
	mv.setViewName("showallusers");
	return mv;
}
@RequestMapping(value="/getuser")
public ModelAndView searchUser(@RequestParam("id") int id){
	User user=userService.getUser(id);
	ModelAndView mv=new ModelAndView();
	mv.addObject("user",user);
	mv.setViewName("showuser");
	return mv;
}

@RequestMapping(value="/saveuser", method=RequestMethod.POST)
public ModelAndView saveData(@ModelAttribute("user") User user, @RequestParam("file") MultipartFile file){
	ModelAndView mv=new ModelAndView();
	byte b[]=null;
	try {
		b = file.getBytes();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Blob blob=BlobProxy.generateProxy(b);
	user.setUserPic(blob);
	userService.saveUser(user);
	mv.setViewName("confirm");
	return mv;
}


@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
public void showImage(@RequestParam("id") Integer userId, HttpServletResponse response,HttpServletRequest request) 
        throws ServletException, IOException{
  User user = userService.getUser(userId);
  response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
  Blob blob=user.getUserPic();
  byte b[]=null;
try {
	b = blob.getBytes(1, (int) blob.length());
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  response.getOutputStream().write(b);
  response.getOutputStream().close();
}
}