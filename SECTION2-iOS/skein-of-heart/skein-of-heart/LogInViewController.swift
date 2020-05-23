//
//  LogInViewController.swift
//  skein-of-heart
//
//  Created by hyovely on 2020/05/13.
//  Copyright © 2020 MobileX.IVIS.CWNU. All rights reserved.
//

import UIKit
import Firebase
import GoogleSignIn
import FirebaseAuth


class LogInViewController: UIViewController {
    
    @IBOutlet weak var signInButton: GIDSignInButton!
    
    @IBAction func signIn(_ sender: Any) {
        GIDSignIn.sharedInstance().signIn()

    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        GIDSignIn.sharedInstance()?.presentingViewController = self
        Auth.auth().addStateDidChangeListener({ (user, err) in
            if Auth.auth().currentUser != nil{
                // 로그인이 이미 된 상태면 화면 이동 
                self.performSegue(withIdentifier: "Home", sender: nil)
                print("화면 호출")
            } else {
            }
        })
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
