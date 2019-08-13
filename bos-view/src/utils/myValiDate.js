 /**
   * 手机号码校验
   */
  export function phoneNumber(rule, value, callback) {
    if (value && (!(/^[1][34578]\d{9}$/).test(value) || !(/^[1-9]\d*$/).test(value) || value.length !== 11)) {
      callback(new Error('手机号码不符合规范'))
    } else {
      callback()
    }
  }
  /**
   * 电话号码校验
   */
  export function telephoneNumber(rule, value, callback) {
    if (value && (!(/^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/).test(value))) {
      callback(new Error('电话号码不符合规范'))
    } else {
      callback()
    }
  }
  /**
   * 邮箱校验
   */
 export function emailValue(rule, value, callback) {
    let temp = /^[\w.\-]+@(?:[a-z0-9]+(?:-[a-z0-9]+)*\.)+[a-z]{2,3}$/
    let tempOne = /^[A-Za-zd]+([-_.][A-Za-zd]+)*@([A-Za-zd]+[-.])+[A-Za-zd]{2,5}$/
    if (value && (!(temp).test(value))) {
      callback(new Error('邮箱格式不符合规范'))
    } else {
      callback()
    }
  }
  /**
   * 身份证号码校验
   */
  export function idCard(rule, value, callback) {
    if (value && (!(/\d{17}[\d|x]|\d{15}/).test(value) || (value.length !== 15 && value.length !== 18))) {
      callback(new Error('身份证号码不符合规范'))
    } else {
      callback()
    }
  }
  /**
   * 正整数校验
   */
  export function integerP(rule, value, callback) {
    if (value && !(/^[1-9]\d*$/).test(value)) {
      callback(new Error('只能填写正整数'))
    } else {
      callback()
    }
  }
  /**
   * 英文字符校验
   */
 export function enText(rule, value, callback) {
    // let a = '',
    //   arr = value.split(" ")
    // for (let i = 0; i < arr.length; i++) { //删除行内空格
    //   a += arr[i];
    // }
    if (value && !(/^[A-Za-z]+$/).test(value)) {
      callback(new Error('只能填写英文字符'))
    } else {
      callback()
    }
  }
  /**
   * 中文字符英文字符校验
   */
  export function ChEnText(rule, value, callback) {
    if (value && !(/^[A-Za-z0-9]+$/).test(value)) {
      callback(new Error('只能填写数字和英文字符'))
    } else {
      callback()
    }
  }
  /**
   * 只能输入英文或者数字
   */
 export function enOrnunText (rule, value, callback) {
    if (value && !(/^[A-Za-z0-9]+$/).test(value)) {
      callback(new Error('只能填写英文或者数字'))
    } else {
      callback()
    }
  }
  /**
   * 20位数字国标编码校验，且为正整数
   */
  export function validateDeviceNo (rule, value, callback) {
    if (value && !(/^[1-9]\d*$/).test(value)) {
      callback(new Error('只能填写正整数'))
    } else {
      if (!/^[0-9]{20}$/.test(value)) {
        callback(new Error('请输入20位数字的编码！'));
      } else {
        callback();
      }
    }
  }
  /**
   * 校验字符长度
   */
  export function validateLength (rule, value, callback) {
    let codeLen = value.toString().length
    if(codeLen>12){
      callback(new Error('输入的长度不能大于12位,请重新输入'))
    }
  }
