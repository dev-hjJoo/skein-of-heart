//
//  DiaryPageViewController.swift
//  skein-of-heart
//
//  Created by hyovely on 2020/05/09.
//  Copyright © 2020 MobileX.IVIS.CWNU. All rights reserved.
//

import UIKit

class DiaryPageViewController: UIViewController, UITextViewDelegate {

    @IBOutlet weak var textView: UITextView!
    var countOfText: Int = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        textView.delegate = self
        textView.textColor = UIColor.lightGray
        textView.text = "오늘 하루 어떤 하루를 보내셨나요? :)"
    }
    
    // MARK: textView 관련 Methods
    // PlaceHolder 설정: 편집이 시작될 때 내용 지워지게 하기
    func textViewDidBeginEditing(_ textView: UITextView) {
        textView.text = ""
        textView.textColor = UIColor.black
        
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
