package kr.easw.lesson05.controller;

import kr.easw.lesson05.model.dto.TextDataDto;
import kr.easw.lesson05.service.TextDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

// @RestController 어노테이션을 사용하여 이 클래스가 REST 컨트롤러임을 선언합니다.
@RestController
// @RequestMapping 어노테이션을 사용하여 이 클래스의 기반 엔드포인트를 /api/v1/data로 설정합니다.
@RequestMapping("/api/v1/data")
// final로 지정된 모든 필드를 파라미터로 가지는 생성자를 생성합니다.
@RequiredArgsConstructor
public class DataRestEndpoint {
    private final TextDataService textDataService;

    // 이 메서드의 엔드포인트를 /api/v1/data/add로 설정합니다. POST만 허용됩니다.
    @PostMapping("/add")
    public ModelAndView addText(@RequestParam Map<String, String> data) {
        textDataService.addText(new TextDataDto(0L, data.get("text")));
        return new ModelAndView("redirect:/admin?success=true");
    }

    // 이 메서드의 엔드포인트를 /api/v1/data/list로 설정합니다. POST만 허용됩니다.
    @PostMapping("/list")
    public List<TextDataDto> listText() {
        return textDataService.listText();
    }


}
