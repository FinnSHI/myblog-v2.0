package com.finn.blog.controller;


import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author finn
 * @since 2022-04-13
 */
@RestController
public class MessageController {
//
//    @Autowired
//    private MessageService messageService;
//
//    /**
//     * 添加留言
//     *
//     * @param messageVO 留言信息
//     * @return {@link Result<>}
//     */
//    @ApiOperation(value = "添加留言")
//    @PostMapping("/messages")
//    public Result<?> saveMessage(@Valid @RequestBody MessageVO messageVO) {
//        messageService.saveMessage(messageVO);
//        return Result.ok();
//    }
//
//    /**
//     * 查看留言列表
//     *
//     * @return {@link Result<MessageDTO>} 留言列表
//     */
//    @ApiOperation(value = "查看留言列表")
//    @GetMapping("/messages")
//    public Result<List<MessageDTO>> listMessages() {
//        return Result.ok(messageService.listMessages());
//    }
//
//    /**
//     * 查看后台留言列表
//     *
//     * @param condition 条件
//     * @return {@link Result<MessageBackDTO>} 留言列表
//     */
//    @ApiOperation(value = "查看后台留言列表")
//    @GetMapping("/admin/messages")
//    public Result<PageResult<MessageBackDTO>> listMessageBackDTO(ConditionVO condition) {
//        return Result.ok(messageService.listMessageBackDTO(condition));
//    }
//
//    /**
//     * 审核留言
//     *
//     * @param reviewVO 审核信息
//     * @return {@link Result<>}
//     */
//    @OptLog(optType = UPDATE)
//    @ApiOperation(value = "审核留言")
//    @PutMapping("/admin/messages/review")
//    public Result<?> updateMessagesReview(@Valid @RequestBody ReviewVO reviewVO) {
//        messageService.updateMessagesReview(reviewVO);
//        return Result.ok();
//    }
//
//    /**
//     * 删除留言
//     *
//     * @param messageIdList 留言id列表
//     * @return {@link Result<>}
//     */
//    @OptLog(optType = REMOVE)
//    @ApiOperation(value = "删除留言")
//    @DeleteMapping("/admin/messages")
//    public Result<?> deleteMessages(@RequestBody List<Integer> messageIdList) {
//        messageService.removeByIds(messageIdList);
//        return Result.ok();
//    }
}
