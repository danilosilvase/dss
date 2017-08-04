/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import examples.FTApplication;
import examples.FTExample;
import fogtorch.deployment.Search;

/**
 *
 * @author Stefano
 */
public class MainJRN {

    public static void main(String[] args) {
    	//FTApplication example = new FTApplication();
        FTExample example = new FTExample();
        Search result = example.start();
        System.out.println(result.D);
    }
}
