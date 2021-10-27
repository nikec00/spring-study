package com.nik.demo.demo02;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/4/4 12:13
 */
public class UserServiceProxy implements UserService{
    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void save() {
        log("save");
        userService.save();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void find() {
        log("find");
        userService.find();
    }

    public void log(String str){
        System.out.println("[debug]执行了" + str + "方法");
    }
}
