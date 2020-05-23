//
//  UserInfoViewController.swift
//  skein-of-heart
//
//  Created by hyovely on 2020/05/20.
//  Copyright © 2020 MobileX.IVIS.CWNU. All rights reserved.
//

import UIKit
import FirebaseAuth

class UserInfoViewController: UIViewController {

    // MARK: Outlets
    @IBOutlet weak var userName: UILabel!
    @IBOutlet weak var userEmail: UILabel!
    @IBOutlet weak var userImage: UIImageView!
    
    
    // MARK: Actions
    @IBAction func LogOut(_ sender: Any) {
        let firebaseAuth = Auth.auth()
        do {
          try firebaseAuth.signOut()
        } catch let signOutError as NSError {
          print ("Error signing out: %@", signOutError)
        }
        dismiss(animated: true, completion: nil)
    }
//    
//    func touchToPickPhoto() {
//        
//    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // MARK: 로그인
        userName.text = (Auth.auth().currentUser?.displayName)!+" 의 로그인 정보"
        userEmail.text = Auth.auth().currentUser?.email

        /*
        // MARK: ImageView 터치 인식
        let tapGesture = UITapGestureRecognizer(target: self, action: #selector(touchToPickPhoto()))
        userImage.addGestureRecognizer(tapGesture)
        userImage.isUserInteractionEnabled(true)
         */
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
