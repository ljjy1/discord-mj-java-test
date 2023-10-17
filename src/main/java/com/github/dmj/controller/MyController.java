package com.github.dmj.controller;

import com.github.dmj.model.*;
import com.github.dmj.service.DiscordService;
import com.github.dmj.utils.FileUtils;
import com.github.dmj.vo.ImagineResponse;
import com.github.dmj.vo.Ret;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author ljjy1
 * @classname MyController
 * @description TODO
 * @date 2023/10/17 14:36
 */
@Tag(name = "DiscordController", description = "discord画图接口")
@RequestMapping("/api/discord")
@RestController
@Slf4j
public class MyController {


    @Resource
    private DiscordService discordService;




    @PostMapping("/imagine")
    @Operation(summary = "文生图/图生图 返回唯一业务ID")
    public Ret<ImagineResponse> imagine(@RequestBody ImagineInRequest request){
        Integer imagine = discordService.imagine(request);
        return Ret.success(new ImagineResponse().setTriggerId(imagine));
    }



    @PostMapping("/upscale")
    @Operation(summary = "图片细节增强 对应图片U1 U2 U3 U4")
    public Ret<ImagineResponse> upscale(@RequestBody UpscaleVariationRequest request){
        Integer imagine = discordService.upscale(request);
        return Ret.success(new ImagineResponse().setTriggerId(imagine));
    }


    @PostMapping("/variation")
    @Operation(summary = "图片变化 对应图片 V1 V2 V3 V4")
    public Ret<ImagineResponse> variation(@RequestBody UpscaleVariationRequest request){
        Integer imagine = discordService.variation(request);
        return Ret.success(new ImagineResponse().setTriggerId(imagine));
    }


    @PostMapping("/reset")
    @Operation(summary = "图片重绘 对应刷新按钮")
    public Ret<ImagineResponse> reset(@RequestBody ResetRequest request){
        Integer imagine = discordService.reset(request);
        return Ret.success(new ImagineResponse().setTriggerId(imagine));
    }


    @PostMapping("/low/variation")
    @Operation(summary = "单张图片 微改变Subtle")
    public Ret<ImagineResponse> soloLowVariation(@RequestBody SoloVariationRequest request){
        Integer imagine = discordService.soloLowVariation(request);
        return Ret.success(new ImagineResponse().setTriggerId(imagine));
    }


    @PostMapping("/high/variation")
    @Operation(summary = "单张图片 较大改变Strong")
    public Ret<ImagineResponse> soloHighVariation(@RequestBody SoloVariationRequest request){
        Integer imagine = discordService.soloHighVariation(request);
        return Ret.success(new ImagineResponse().setTriggerId(imagine));
    }


    @PostMapping("zoomOut")
    @Operation(summary = "对单张图片进行缩小操作zoomout(2x:50 1.5X 75)")
    public Ret<ImagineResponse> zoomOut(@RequestBody ZoomOutRequest request){
        Integer imagine = discordService.zoomOut(request);
        return Ret.success(new ImagineResponse().setTriggerId(imagine));
    }


    @PostMapping("expand")
    @Operation(summary = "图片进行某方向的扩展 (left/right/up/down)")
    public Ret<ImagineResponse> expand(@RequestBody ExpandRequest request){
        Integer imagine = discordService.expand(request);
        return Ret.success(new ImagineResponse().setTriggerId(imagine));
    }


    @PostMapping("/uploadFile/{userKey}")
    @Operation(summary = "上传文件至discord服务器")
    public Ret<UploadDiscordResponse> uploadFile(@PathVariable("userKey") String userKey, @RequestParam("file") MultipartFile file){
        UploadDiscordResponse uploadDiscordResponse = discordService.uploadFileToDiscord(userKey, FileUtils.multipartFileToFile(file));
        return Ret.success(uploadDiscordResponse);
    }


    @PostMapping("/get/uploadFile/url")
    @Operation(summary = "获取上传文件的url 用于图生图 返回下载链接")
    public Ret<String> getUploadFileUrl(@RequestBody GetUploadFileRequest request){
        String uploadFileUrl = discordService.getUploadFileUrl(request);
        return Ret.success(uploadFileUrl);
    }


}
