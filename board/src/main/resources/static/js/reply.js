/*
* reply modules
*
* Javascript 모듈화
*   함수들을 하나의 모듈처럼 묶음으로 구성하는 것을 의미한다.
*   화면 내에서 Javascript 처리를 하다 보면 이벤트 처리와 DOM, Ajax 처리 등
*   복잡하게 섞여서 유지보수가 힘들다. 따라서 Javascript를 하나의 모듈처럼 구성하여 사용한다.
*
* */
console.log("Reply Modules.......");

let replyService = (function(){

    //댓글 추가
    function add(reply, callback, error) {
        console.log("add reply..........")
        $.ajax({
            type: "POST",
            url: "/replies/new",
            //  json 객체를 String 객체로 변환
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function(result, status, xhr){
                if(callback){
                    callback(result);
                }
            },
            error: function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        });
    }

    //댓글 목록
    function getList(param, callback, error){
        let bno = param.bno;
        let page = param.page || 1;

        $.getJSON("/replies/list/" + bno + "/" + page, function(list){
            if(callback){
                callback(list);
            }
        }).fail(function(xhr, status, er){
            if(error){
                error(er);
            }
        });

        // $.ajax({
        //     type: "GET",
        //     url: "/replies/list/" + bno + "/" + page,
        //     success: function (list) {
        //         if (callback) {
        //             callback(list);
        //         }
        //     },
        //     error: function (xhr, status, er) {
        //         if (error) {
        //             error(er);
        //         }
        //     }
        // });
    }

    //댓글 조회
    function read(rno, callback, error){
        $.get("/replies/" + rno, function(result){
            if(callback){
                callback(result);
            }
        }).fail(function(xhr, status, er){
            if(error){
                error(er);
            }
        })
    }

    //댓글 삭제
    function remove(rno, callback, error){
        $.ajax({
            type: "DELETE",
            url: "/replies/" + rno,
            success: function(result) {
                if(callback){
                    callback(result);
                }
            },
            error: function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        });
    }

    return {add: add, getList: getList, read: read, remove: remove}
})();