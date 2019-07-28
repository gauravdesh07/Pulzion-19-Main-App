package com.example.tanush.maindemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class
EventDetails extends AppCompatActivity implements Serializable {

    Map<String,String> map;
    ArrayList<String>  arrayList;

    TextView event_name,event_description,quote,event_rules,team_distribution,fees,contact1,contact2;
    ImageView imageView;
    Bundle bundle;

    StringBuilder final1=new StringBuilder(" "),final2=new StringBuilder(" ");
    StringBuilder temp1=new StringBuilder(" "),temp2=new StringBuilder(" ");
    Toolbar toolbar=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);


        EventSnapshot temp= (EventSnapshot) getIntent().getSerializableExtra("EVENT_DETAILS");
        event_name=findViewById(R.id.eventName);

        if(temp.getImageView()!=0)
            temp.setImageView(temp.getImageView());
        event_description=findViewById(R.id.eventDescription);
        quote=findViewById(R.id.textView1);
        event_rules=findViewById(R.id.rules);
        team_distribution=findViewById(R.id.team_distribution);
        fees=findViewById(R.id.fees);
        contact1=findViewById(R.id.contact1);
        contact2=findViewById(R.id.contact2);
        imageView=findViewById(R.id.eventImage);
        Glide.with(this).load(getResources().getDrawable(temp.getImageView())).into(imageView);
        //imageView.setImageResource(temp.getImageView());
        event_name.setText(temp.getEvent_name());
        String s1;
        if(temp.getEvent_name().equals("Cerebro"))
            s1=temp.getEvent_name_description();
        else
        {
            s1=temp.getEvent_name_description();
            //s2.replaceAll("\\n", "\n");
            if(s1!=null)
                if(s1.contains("\\n"))
                {
                    s1=s1.replace("\\n","\n");
                }
        }
        event_description.setText(s1);
        quote.setText(temp.getEvent_name_quote());
        String s2;
        if(temp.getEvent_name().equals("Cerebro"))
            s2=temp.getEvent_name_description();
        else
        {
            s2=temp.getEvent_rules_description();
            //s2.replaceAll("\\n", "\n");
            if(s2!=null)
                if(s2.contains("\\n"))
                {
                    s2=s2.replace("\\n","\n");
                }
        }

        event_rules.setText(s2);

        String s3;
        s3=temp.getEvent_team_distribution();
        //s2.replaceAll("\\n", "\n");
        if(s3!=null)
            if(s3.contains("\\n"))
            {
                s3=s3.replace("\\n","\n");
            }
         /*ObjectAnimator anim = ObjectAnimator.ofFloat(imageView, "ScaleY", 0, 1);
        anim.setDuration(1000);
        anim.start();*/
//        ObjectAnimator anim = ObjectAnimator.ofFloat(imageView, "Alpha", 0, 1);
//        anim.setRepeatMode(ObjectAnimator.REVERSE);
//        anim.setRepeatCount(ObjectAnimator.RESTART);
//        anim.setDuration(700);
//        anim.start();

       /* Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        imageView.startAnimation(animation);*/
        team_distribution.setText(s3);
        fees.setText(temp.getEvent_fees());
        String con1="",con2="";
        int n1,n2;
        int cursor1=0,cursor2=0;
        n1=temp.contact1.length();
        n2=temp.contact2.length();
        for(int i=0;i<n1;i++)
        {
            if(temp.contact1.charAt(i)==' '&&temp.contact1.charAt(i-1)==':') {
                cursor1 = i + 1;
                break;
            }
            else
                temp1.append(temp.contact1.charAt(i));
        }

        for(int i=0;i<n2;i++)
        {
            if(temp.contact2.charAt(i)==' '&&temp.contact2.charAt(i-1)==':') {
                cursor2 = i + 1;
                break;
            }
            else
                temp2.append(temp.contact2.charAt(i));

        }

        for(int i=cursor1;i<n1;i++)
            final1.append(temp.contact1.charAt(i));
        for(int i=cursor2;i<n2;i++)
            final2.append(temp.contact2.charAt(i));

        //TextView textView = (TextView) view.findViewById(R.id.textview);
        SpannableString content = new SpannableString(final1);
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        String str1=temp1.toString()+content;
        contact1.setText(str1);

        SpannableString content2 = new SpannableString(final2);
        content2.setSpan(new UnderlineSpan(), 0, content2.length(),0 );
        String str2=temp2.toString()+content2;
        contact2.setText(str2);

//
//        contact1.setText(temp.contact1);
//        contact2.setText(temp.contact2);
        contact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+final1.toString().trim()));
                startActivity(intent);
            }
        });

        contact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+final2.toString().trim()));
                startActivity(intent);
            }
        });

    }
}