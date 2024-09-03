package com.example.doanmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerviewActivity extends AppCompatActivity implements UserAdapter.Usercallback  {
    RecyclerView rvListC;
    ArrayList<User> lstUser;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        rvListC = findViewById(R.id.rvList);
        //
        LoadData();
        userAdapter = new UserAdapter(lstUser,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvListC.setLayoutManager(linearLayoutManager);
        rvListC.setAdapter(userAdapter);
    }
    @Override
    public void onItemClick(String id) {
        Intent i = new Intent(this, DetailsActivity.class);
        i.putExtra("userId", id);
        startActivity(i);
    }
    void LoadData()
    {
        lstUser = new ArrayList<>();
        lstUser.add(new User("Em là [F]ai từ đâu bước [G]đến nơi đây dịu [Am]dàng chân phương \n" +
                "Em là [F]ai tựa như ánh [G]nắng ban mai ngọt [C]ngào trong sương \n" +
                "Ngắm em [F]thật [G]lâu con [Am]tim anh yếu [Em]mềm\n" +
                "Đắm say [F]từ phút đó [G]từng giây trôi yêu [C]thêm ! \n" +
                " \n" +
                "Bao ngày [F]qua bình minh đánh [G]thức xua tan bộn [Am]bề nơi anh \n" +
                "Bao ngày [F]qua niềm thương nỗi [G]nhớ bay theo bầu [C]trời trong xanh \n" +
                "Liếc đôi [F]hàng [G]mi mong [Am]manh anh thẫn [Em]thờ \n" +
                "Muốn hôn [F]nhẹ mái tóc [G]bờ môi em anh [C]mơ  [C7]\n" +
                " \n" +
                "ĐK:\n" +
                "Cầm tay [F]anh dựa vai [G]anh kề bên [Am]anh nơi này có [Em]anh \n" +
                "Gió mang câu tình [F]ca \n" +
                "Ngàn ánh sao vụt [G]qua \n" +
                "Nhẹ ôm lấy [C]em [C7]\n" +
                "(Yêu em thương em con tim anh chân thành)\n" +
                " \n" +
                "Cầm tay [F]anh dựa vai [G]anh kề bên [Am]anh nơi này có [Em]anh \n" +
                "Khép đôi mi thật [F]lâu \n" +
                "Nguyện mãi bên canh [G]nhau \n" +
                "Yêu say đắm như ngày [C]đầu!\n" +
                " \n" +
                "Mùa xuân đến [F]bình [G]yên cho [Am]anh những giấc [Em]mơ \n" +
                "Hạ lưu giữ [F]ngày [G]mưa gió ngọt [C]ngào nên thơ  [C7]\n" +
                "Mùa thu lá [F]vàng [G]rơi đông [Am]sang anh nhớ [Em]em \n" +
                "Tình yêu bé [F]nhỏ [G]xin giành [C]tặng riêng em \n" +
                " \n" +
                "Dạo vòng hòa thanh: [F] [G] [Am] [Em]... [F] [G] [C]  [C]","Nơi này có anh", "noinaycoanh.jpg"));
        lstUser.add(new User("Bóng ai [Am]đó nhẹ nhàng vụt qua nơi đây\n" +
                "Quyến rũ ngây [F]ngất loạn nhịp làm tim mê say\n" +
                "Cuốn lấy áng [Dm]mây theo cơn sóng xô dập dìu\n" +
                "Nụ cười ngọt ngào cho [E7]ta tan vào \n" +
                "phút giây miên man quên hết con đường về \n" +
                " \n" +
                "Ehhh [Am]\n" +
                "Chẳng thể tìm thấy lối về ehhhhh [F]\n" +
                "Điệu nhạc hòa quyện trong ánh [Dm]mắt đôi môi\n" +
                "Dẫn lối những bối rối rung động [E7]khẽ lên ngôi\n" +
                " \n" +
                "Chạm nhau mang vô vàn\n" +
                "[Am]Đắm đuối vấn vương dâng tràn\n" +
                "Lấp kín chốn nhân gian\n" +
                "[F]Làn gió hoá sắc hương mơ màng\n" +
                "Một giây ngang qua [Dm]đời\n" +
                "Cất tiếng nói không nên lời\n" +
                "Ấm áp đến trao tay ngàn [E7]sao trời lòng càng thêm chơi vơi\n" +
                "Dịu êm không gian [Am]bừng sáng đánh thức muôn hoa mừng\n" +
                "Quấn quít hát ngân nga [F]từng chút níu bước chân em dừng\n" +
                "Bao ý thơ tương tư ngẩn [Dm]ngơ\n" +
                "Lưu dấu nơi mê cung đẹp [E7]thẫn thờ\n" +
                " \n" +
                "[Am]...Hãy trao cho anh \n" +
                "Hãy trao cho anh\n" +
                "[F]...Hãy trao cho anh thứ anh đang mong [Dm]chờ\n" +
                "Hãy trao cho anh\n" +
                "Hãy trao cho anh\n" +
                "[E7]...Hãy mau làm điều ta muốn vào khoảnh khắc này đê\n" +
                "[Am]...Hãy trao cho anh\n" +
                "Hãy trao cho anh\n" +
                "[F]...Hãy trao anh trao cho anh đi những yêu thương nồng [Dm]cháy\n" +
                "Trao anh ái ân nguyên vẹn [E7]đong đầy","Hãy trao cho anh", "haytraochoanh.jpg"));
        lstUser.add(new User("Phiên khúc 1:\n" +
                "Thấp thoáng ánh [Gmaj7]mắt đôi môi mang theo hương mê say\n" +
                "Em cho anh tan [F#m7]trong miên man quên luôn đi đêm [Bm7]ngày\n" +
                "Chạm nhẹ vội vàng [Gmaj7]hai ba giây nhưng con tim đâu hay\n" +
                "Bối rối khẽ lên [F#m7]ngôi yêu thương đong đầy thật [Bm7]đầy\n" +
                "Anh ngẩn ngơ cứ [Gmaj7]ngỡ (đó chỉ là giấc mơ)\n" +
                "Anh ngẩn ngơ cứ [F#m7]ngỡ (như đang ngất ngây trong giấc [Bm7]mơ)\n" +
                "Thật ngọt ngào [Em7]êm dịu [D11]đắm chìm \n" +
                "[Gmaj7]Phút chốc viết tương tư gieo nên [A11]thơ\n" +
                " \n" +
                "[Gmaj7]Có câu ca trong gió hát ngân nga ru trời mây \n" +
                "Nhẹ nhàng [F#m7]đón ban mai ngang qua trao nụ [Bm7]cười\n" +
                "[Gmaj7]Nắng đua chen khoe sác vui đùa giữa muôn ngàn hoa \n" +
                "Dịu dàng [F#m7]đến nhân gian âu yếm tâm hồn [Bm7]người\n" +
                "Hình như chính [Gmaj7]em (cho anh mong chờ)\n" +
                "Hình như chính là [F#m7]em (cho anh vấn [Bm7]vương)\n" +
                "Đừng thờ ơ xin [Em7]hãy lắng nghe và [D11]giúp anh \n" +
                "Trả lời [Gmaj7]đôi điều còn băn [A11]khoăn.\n" +
                " \n" +
                "Điệp khúc:\n" +
                "Có chắc yêu là [Gmaj7]đây... đây... đây\n" +
                "Có chắc yêu là [F#m7]đây... [Bm7]đây\n" +
                "Có chắc yêu là [Gmaj7]đây... đây... đây\n" +
                "Có chắc yêu là [F#m7]đây... [Bm7]đây\n" +
                "Em lang thang cả ngày [Gmaj7]trong tâm trí\n" +
                "Đi không ngừng cả ngày [F#m7]trong tâm trí [Bm7]\n" +
                "Si mê thêm cuồng [Em7]quay [D11]\n" +
                "[Gmaj7]Ah [A11]uhhhhh\n" +
                "Có chắc yêu là [Gmaj7]đây\n" +
                " \n" +
                "Phiên khúc 2:\n" +
                "[Gmaj7]Chắc gì nữa mà chắc\n" +
                "Sáng thì nhớ đêm [F#m7]trắng tương tư còn không yêu là [Bm7]gì?\n" +
                "Có chắc yêu là [Gmaj7]đây\n" +
                "Rồi thắc gì nữa mà mắc\n" +
                "Đến bên nắm tay [F#m7]nói ra ngay rồi mơ mộng thêm làm [Bm7]gì\n" +
                "Nhanh chân chạy mua một bó [Gmaj7]hoa thêm luôn một món quà\n" +
                "Khuôn mặt tươi cười [F#m7]lên vô tư gạt đi âu lo mạnh mẽ [Bm7]nha\n" +
                "Và rồi bước [Em7]ra...bước [D11]ra...bước [Gmaj7]ra... [A11]","Có chắc yêu là đây", "cochacyeuladay.jpg"));
        lstUser.add(new User("Muộn rồi mà sao [F]còn\n" +
                "Nhìn [Fm]lên trần nhà rồi quay ra\n" +
                "Lại [Em]quay vào\n" +
                "Nằm [Am]trằn trọc vậy đến sáng mai\n" +
                "Ôm tương [Dm]tư, nụ cười của ai đó\n" +
                "Làm con [G]tim ngô nghê như muốn khóc òa\n" +
                "[C]Vắt tay lên trên trán mơ mộng\n" +
                "Được [C7]đứng bên em trong nắng xuân hồng\n" +
                "1 giờ [F]sáng\n" +
                "Trôi [Fm]qua trôi nhanh kéo theo ưu phiền miên [Em]man\n" +
                "Âm thầm [Am]gieo tên em vẽ lên hi vọng\n" +
                "[Dm]Đúng là yêu thật rồi còn [G]không thì \n" +
                "hơi phí này cứ [C]thế loanh quanh loanh\n" +
                " quanh loanh quanh lật [C7]qua lật lại (2 giờ)\n" +
                " \n" +
                "[F]Những ngôi sao trên cao\n" +
                "[Fm]Là người bạn tâm giao \n" +
                "[Em]Lắng nghe anh luyên thuyên về\n" +
                " một tình [Am]đầu đẹp tựa chiêm bao\n" +
                "[Dm]Có nghe thôi đã thấy ngọt ngào\n" +
                "Đủ [G]biết anh si mê em nhường nào\n" +
                "[C]Ít khi văn thơ anh dạt dào bụng\n" +
                " [C7]đói nhưng vui quên luôn cồn cào\n" +
                " \n" +
                "[F]Nắm đôi tay kiêu sa\n" +
                "[Fm]Được một lần không ta\n" +
                "[Em]Nghĩ qua thôi con tim trong anh\n" +
                " đập [Am]tung lên rung nóc rung nhà\n" +
                "[Dm]Hóa ra yêu đơn phương một người\n" +
                "[G]Hóa ra khi tơ vương một người\n" +
                "[C]3 giờ đêm vẫn ngồi [C7]cười\n" +
                " \n" +
                "Cứ ôm anh [F]đi ôm anh đi ôm anh [Fm]đi ôm anh đi\n" +
                "Ôm trong cơn [Em]mơ trong cơn\n" +
                " mơ trong cơn [Am]mơ trong cơn mơ\n" +
                "Có thế cũng [Dm]khiến anh vui điên lên\n" +
                "[G]Ngỡ như em đang bên\n" +
                "Chấp [C]bút đôi ba câu thơ ngọt ngào [C7]muốn em đặt tên\n","Muộn rồi mà sao còn", "muonroimasaocon.jpg"));
        lstUser.add(new User("Từng [Bbmaj7]phút cứ mãi trôi xa phai nhòa dần [C]kí ức giữa đôi ta \n" +
                "Từng [Dm]chút nỗi nhớ hôm qua \n" +
                "đâu về lạc [Am]bước cứ thế phôi pha \n" +
                "Con [Bbmaj7]tim giờ không cùng chung đôi nhịp \n" +
                "Nụ cười lạnh[C] băng còn đâu nồng ấm thân quen \n" +
                "Vô tâm làm [Dm]ngơ thờ ơ tương lai ai ngờ \n" +
                "Quên đi mộng [Am]mơ ngày thơ tan theo sương mờ \n" +
                " \n" +
                "Mưa lặng [Bbmaj7]thầm đường vắng chiều nay \n" +
                "In giọt [C]lệ nhòe khóe mắt sầu cay \n" +
                "Bao hẹn [Dm]thề tàn úa vụt bay \n" +
                "Trôi dạt [Am]chìm vào những giấc nồng say \n" +
                "Quay lưng chia hai [Bbmaj7]lối \n" +
                "Còn một mình anh thôi\n" +
                "Giả [C]dối bao trùm bỗng chốc lên ngôi \n" +
                "Trong đêm[Dm] tối \n" +
                "Bầu bạn cùng đơn côi\n" +
                "Suy tư anh kìm [Am]nén đã bốc cháy yêu thương trao em rồi \n" +
                " \n" +
                "Đốt sạch [Bbmaj7]hết \n" +
                "Son môi hồng vương trên môi bấy lấu\n" +
                "[C]Hương thơm dịu êm mê man bấy lâu \n" +
                "Đốt sạch [Dm]hết \n" +
                "Anh không chờ mong quan tâm nữa đâu\n" +
                "[Am]Tương lai từ giờ như bức tranh em quên tô màu \n" +
                "Đốt sạch [Bbmaj7]hết \n" +
                "Xin chôn vùi tên em trong đớn đau\n" +
                "[C]Nơi hiu quạnh tan hoang ngàn nỗi đau \n" +
                "Đốt sạch [Dm]hết \n" +
                "Dư âm tàn tro vô vọng phía sau\n" +
                "[Am]Đua chen dày vò xâu xé quanh thân xác nát nhàu \n" +
                " \n" +
                "Chạy [Bbmaj7]ngay đi trước khi \n" +
                "[C]Mọi điều dần tồi tệ hơn \n" +
                "Chạy [Dm]ngay đi trước khi \n" +
                "[Am]Lòng hận thù cuộn từng cơn \n" +
                "Tựa [Bbmaj7]giông tố đến bên ghé thăm \n" +
                "Từ [C]nơi hố sâu tối tăm \n" +
                "[Dm]Chạy đi trước khi \n" +
                "[Am]Mọi điều dần tồi tệ hơn ","Chạy ngay đi", "chayngaydi.jpg"));
        lstUser.add(new User("Nắng ấm xa dần\n" +
                "Chuuuu…\n" +
                "Chẳng phải anh đâu..\n" +
                "Chuuuu…\n" +
                "C phải anh đâu…!!!\n" +
                "Nắng ấm xa [Amaj7]dần rồi.\n" +
                "Nắng ấm xa [B]dần rồi.\n" +
                "Nắng ấm xa [G#m]dần bỏ rơi,để lại \n" +
                "những giấc [C#m]mơ.(giữ lại đi,giữ lại đi.)\n" +
                "Nắng ấm xa [Amaj7]dần rồi.\n" +
                "Nắng ấm xa [B]dần rồi.\n" +
                "Nắng ấm xa [G#m]dần,xa dần theo những tiếng\n" +
                " [C#m]cười.(Hãy mang đi giúp những nỗi buồn)\n" +
                "[Amaj7]Theo thời gian những hạt [B]mưa như nặng thêm.\n" +
                "Xóa hết thương [G#m]yêu mặn nồng ngày nào giữa chúng [C#m]ta.\n" +
                "Anh lục tìm vẫn cứ mãi lục tìm.\n" +
                "[Amaj7]Giơ bàn tay cố kìm [B]nén những cảm xúc.\n" +
                "Vùi mình vào đêm [G#m]đen anh chẳng tìm thấy lối [C#m]ra.\n" +
                "Sau lưng là [Amaj7]tiếng nói yêu anh,chẳng rời xa [B]anh.\n" +
                "Trước mắt anh điều [G#m]đấy,nó dối\n" +
                " trá,tại sao người vội quên [C#m]mau?\n" +
                "Là vì em.\n" +
                "Bài ca anh [Amaj7]viết sẽ không được trọn vẹn đâu [B]em.\n" +
                "Bước đi.\n" +
                "Em yêu một [G#m]ai thật rồi mãi chẳng là anh [C#m]đâu.\n" +
                "Vậy thì người cứ bước đi xa nơi [Amaj7]này.\n" +
                "Ánh bình minh sẽ không còn nơi [B]đây.\n" +
                "Bước đi xa nơi [G#m]này.\n" +
                "Những lời yêu sẽ không còn nơi [C#m]đây.\n" +
                "Phải tự đứng [Amaj7]lên mà thôi,che nhẹ\n" +
                " đi những niềm [B]đau và nỗi buồn.\n" +
                "Xung quanh anh giờ [G#m]đây cô đơn mình anh ôm giấc [C#m]mơ.\n" +
                "Nhìn em bước ra đi xa [Amaj7]dần.Ehhhhhh… .[B]\n" +
                "em bước ra đi xa [G#m]dần\n" +
                "Ehhhhh…[C#m]\n" +
                "Nhìn em bước ra đi xa [Amaj7]dần.\n" +
                "Ehhhhh….[B]\n" +
                "Nhìn em bước ra đi xa [G#m]dần…\n" +
                "[C#m]\n" +
                "[Amaj7]Đến rồi lại đi.\n" +
                "Cứ vội vàng đi.","Nắng ấm xa dần", "nangamxadan.jpg"));
        lstUser.add(new User("Tone [Am]\n" +
                "Niềm tin đã [F]mất, giọt nước mắt cuốn kí ức anh chìm [G]sâu \n" +
                "Tình về nơi [Am]đâu, cô đơn \n" +
                "đôi chân lạc trôi giữa [G]bầu trời \n" +
                "Màn đêm che [F]dấu, từng góc tối\n" +
                " khuất lấp phía sau bờ [G]môi! \n" +
                "Tại vì anh [Am]thôi, yêu say mê nên đôi khi quá [G]dại khờ! \n" +
                " \n" +
                "Nhắm mắt ơ [F]thờ anh không\n" +
                " muốn lạc vào trong nỗi [G]đau này \n" +
                "Phía trước bây [Am]giờ ai đang nắm\n" +
                " chặt bàn tay của [G]em vậy ... \n" +
                "Ai vậy???\n" +
                "Mông lung như một trò [F]đùa \n" +
                "Anh xin giơ tay rút lui [G]thôi \n" +
                "Do ai???\n" +
                "Trách ai bây giờ [Am]đây???? \n" +
                "[G]Uhhhhhh .... \n" +
                " \n" +
                "Chúng ta không thuộc về [F]nhau \n" +
                "Chúng ta không thuộc về [G]nhau \n" +
                "Chúng ta không thuộc về [Am]nhau \n" +
                "Em hãy cứ đi bên người mà [G]em cần \n" +
                "Trái tim không thuộc về [F]nhau \n" +
                "Giấc mơ không là của [G]nhau \n" +
                "Xoá câu ca buồn chiều [Am]mưa \n" +
                "Anh lỡ xoá luôn yêu thương ngày [G]xưa rồi \n" +
                "Chúng ta không thuộc về [F]nhau [G] [Am] [G]\n" +
                " \n" +
                "[F]Hey... Từng đêm qua ... Cơn\n" +
                " [G]mưa bao vây chia rời đôi ta \n" +
                "[Am]Em ... Ngày hôm qua ... Cuốn [G]gió theo mây đi về nơi xa \n" +
                "Trời [F]xanh rộng bao la \n" +
                "Anh lê đôi chân mình, [G]bơ vơ lang thang\n" +
                " có lẽ em đang yên vui bên nhân tình \n" +
                "[Am]Quên đi để anh nhớ \n" +
                "Hơi men để anh mơ\n" +
                "[G]Nơi đâu để anh giấu \n" +
                "Một nỗi buồn vào trong thơ\n" +
                " \n" +
                "Nhắm mắt ơ [F]thờ anh không\n" +
                " muốn lạc vào trong nỗi [G]đau này \n" +
                "Phía trước bây [Am]giờ ai đang nắm chặt bàn tay của [G]em vậy \n" +
                "Mông lung như một trò [F]đùa \n" +
                "Anh xin giơ tay rút lui [G]thôi \n" +
                "Do ai???\n" +
                "Trách ai bây giờ [Am]đây???? \n" +
                "[G]Uhhhhhh .... ","Chúng ta không thuộc về nhau", "chungtakhongthuocvenhau.jpg"));
        lstUser.add(new User("[C]Anh tìm nỗi nhớ…. [G]Anh tìm quá khứ.\n" +
                "[Am]Nhớ lắm kí ức anh và [Em]em....\n" +
                "Trả lại [F]anh yêu thương [G]ấy, xin người [Em]hãy về nơi [Am]đây.\n" +
                "Bàn tay [F]yếu ớt cố níu em ở [G]lại….\n" +
                " \n" +
                "[C]Những giọt nước mắt… [G]Lăn dài trên mi.\n" +
                "[Am]Cứ thế anh biết phải làm [Em]sao...\n" +
                "Tình yêu [F]trong em đã [G]mất, phai dần [Em]đi theo gió [Am]bay.\n" +
                "Còn lại [F]chi nơi đây cô đơn riêng [G]anh ….\n" +
                " \n" +
                "[C]Em đi xa quá … Em [G]đi xa anh quá..\n" +
                "Có biết [Am]không nơi đây anh vẫn đứng [Em]đợi một giấc mơ.\n" +
                "Anh chờ [F]đợi một cơn [G]mưa, sẽ xóa [Em]sạch giọt nước [Am]mắt.\n" +
                "Ngồi trong [Dm]đêm bơ vơ anh thấy đau [G]em có biết không????\n" +
                " \n" +
                "[C]Em ơi anh nhớ... Em [G]ơi anh rất nhớ..\n" +
                "Từng câu [Am]nói ánh mắt của em giờ [Em]này ở nơi đâu.\n" +
                "Chắc ai [F]đó sẽ sớm quay lại [G]thôi...\n" +
                "Chắc ai [Em]đó sẽ sớm quay về [Am]thôi...\n" +
                "Cầm bông [Dm]hoa trên tay nước mắt [G]rơi..\n" +
                "Anh nhớ [C]em !\n" +
                " \n" +
                "[C]Những giọt nước mắt… [G]Lăn dài trên mi.\n" +
                "[Am]Cứ thế anh biết phải làm [Em]sao.\n" +
                "Tình yêu [F]trong em đã [G]mất, phai dần [Em]đi theo gió [Am]bay.\n" +
                "Còn lại [Dm]chi nơi đây cô đơn riêng [G]anh ….\n" +
                " \n" +
                "[C]Em đi xa quá … Em [G]đi xa anh quá..\n" +
                "Có biết [Am]không nơi đây anh vẫn đứng [Em]đợi một giấc mơ.\n" +
                "Anh chờ [F]đợi một cơn [G]mưa, sẽ xóa [Em]sạch giọt nước [Am]mắt.\n" +
                "Ngồi trong [F]đêm bơ vơ anh thấy đau [G]em có biết không????\n" +
                " \n" +
                "[C]Em ơi anh nhớ... Em [G]ơi anh rất nhớ..\n" +
                "Từng câu [Am]nói ánh mắt của em giờ [Em]này ở nơi đâu.\n" +
                "Chắc ai [F]đó sẽ sớm quay lại [G]thôi...\n" +
                "Chắc ai [Em]đó sẽ sớm quay về [Am]thôi...\n" +
                "Cầm bông [F]hoa trên tay nước mắt [G]rơi..\n" +
                "Anh nhớ [C]em !","Chắc ai đó sẽ về", "chacaidoseve.jpg"));
        lstUser.add(new User("1.Cuối con [C]đường là bầu trời xanh ấm [G]êm\n" +
                "Bên tôi mỗi khi [Am]buồn lặng lẽ xóa tan âu [Em]lo\n" +
                "Gạt giọt nước [F]mắt thăng [G]trầm \n" +
                "Niềm tin [Em]mãi luôn đong [Am]đầy \n" +
                "Bài ca hát [F]trọn đêm nay dành tặng bạn [G]tôi.\n" +
                " \n" +
                "2.Luôn dõi theo [C]từng nụ cười lặng im phía [G]sau \n" +
                "Bên tôi mãi không [Am]rời mặc nắng gắt hay mưa [Em]ngâu\n" +
                "Dù thời gian có [F]xóa phai [G]nhòa \n" +
                "Lạc [Em]trôi những ký [Am]ức \n" +
                "Bạn tôi vẫn [F]thế không hề đổi thay trái [G]tim. \n" +
                " \n" +
                "ĐK:\n" +
                "Vẫy tay xin [C]chào nghẹn ngào gặp lại ngày [G]sau \n" +
                "Thương nhớ [Am]nhau lòng ngập ngừng không muốn [Em]rời\n" +
                "Vỗ vai xin bình [F]an ở phía [G]trước cho [Em]dù nhiều chông [Am]gai \n" +
                "Kiên cường [F]lên rồi mọi chuyện cũng sẽ vượt [G]qua.\n" +
                " \n" +
                "Dẫu hai phương [C]trời dù nghìn trùng dù xa [G]xôi \n" +
                "Đôi mắt [Am]nhìn hướng tới cuối chân [Em]trời \n" +
                "Cảm ơn bạn người [F]luôn sát [G]bên âm [Em]thầm dõi nhìn [Am]theo \n" +
                "Tay nắm [F]chặt gật đầu cười tim khắc [G]ghi. \n" +
                " \n" +
                "Mãi như ngày hôm [C]qua!","Như ngày hôm qua", "nhungayhomqua.jpg"));
    }
}