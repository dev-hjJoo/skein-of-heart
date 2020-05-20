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
    @IBOutlet weak var userEmail: UILabel!
    
    // MARK: Actions
    @IBAction func LogOut(_ sender: Any) {
        do {
            try Auth.auth().signOut()
        } catch  {
            print(error)
        }
        dismiss(animated: true, completion: nil)
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
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
