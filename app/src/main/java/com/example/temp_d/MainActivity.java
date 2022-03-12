package com.example.temp_d;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 화씨 -> 섭씨 변환 프로그램

    //  주석 추가요
    /* EDT에 화씨를 입력 -> '변환'버튼 클릭 -> 섭씨로 변환
     리니어 레이아웃 3개, 컴포넌트 3개 (EDT, TXTV, BTN)
     리니어 레이아웃 큰 틀 1개(vertical), 그 안에 2개는 horizontal로 정렬 */

    /* '변환'버튼은 이벤트 발생시, SetText()로 저장된 섭씨를 TextView에 뿌려줌
     화씨를 입력받을 변수 1개, 섭씨의 결과를 받을 변수 1개
     화씨는 String형으로, 섭씨는 소수점이 나오기 때문에 Double형 or Float형
     String으로 받은 화씨를 Double.parseDouble을 이용하여 Double형의 섭씨로 캐스팅 */

    /* (32°F − 32) × 5/9 = 0°C  화씨 -> 섭씨 공식
     결과값이 소수가 나오기 위해서는 소수끼리 나눠야하마 즉, 5.0과 9.0을 사용하애햔다
     String.format 방식과 Math.round 방식으로 소수점을 자를 수 있다. *?

    /*  # 내가 범한 오류 #
     Double을 객체형으로 받아왔어야 했는데 소문자 프리미티브 타입은(double) 메소드를 가져다 쓸 수 없다
     Open In 으로 파일 경로 추적 가능 */

    Button transform;
    EditText fahrenheit;
    TextView celsius;
    Double cel ;
    String fahr;

    // cel = String.format("%.2f",cel);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        transform = (Button)findViewById(R.id.transform);   // 변환 버튼
        fahrenheit = (EditText) findViewById(R.id.fahrenheit);
        celsius = (TextView) findViewById(R.id.celsius);

        transform.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

               /* fahr = fahrenheit.getText().toString();
                cel = (Double.parseDouble(fahr) - 32) * (5.0/9.0);
                celsius.setText(cel.toString());
*/
                  fahr = fahrenheit.getText().toString();
                  cel = (Double.parseDouble(fahr) - 32) * (5.0/9.0);
                  celsius.setText(String.format("%.4f",cel));

                return false;

                // TEST
            }
        });
    }
}