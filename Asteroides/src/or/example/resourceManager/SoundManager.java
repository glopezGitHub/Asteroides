package or.example.resourceManager;

import java.util.HashMap;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;

public class SoundManager {

	public final static int SOUND_START = 0;
	
	
	private Context mContext;

	private static SoundManager resourceManager = null;
	private HashMap<Integer, Integer> mSoundPoolMap;
	private SoundPool mSoundPool;
	private AudioManager mAudioManager;
	private float rate = 1.0f;
	
	
	public SoundManager() {
		// TODO Auto-generated constructor stub
	}

	public static SoundManager getInstance() {
		if (resourceManager == null)
			resourceManager = new SoundManager();

		return resourceManager;
	}

	public void initSouns(Context theContext) {
		mContext = theContext;

		mSoundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
		mSoundPoolMap = new HashMap<Integer, Integer>();
		mAudioManager = (AudioManager) mContext
				.getSystemService(Context.AUDIO_SERVICE);

	}

	public void playSound(int index) { 

        int streamVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC); 
        mSoundPool.play(mSoundPoolMap.get(index), streamVolume, streamVolume, 1, 0, rate); 
   }


	public void playSoundLoop(int index) { 
		
		
        int streamVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC); 
        mSoundPool.play(mSoundPoolMap.get(index), streamVolume, streamVolume, 1, -1, 1f);
        
   }

	
	public void addSound(int Index, int SoundID) {
		mSoundPoolMap.put(Index, mSoundPool.load(mContext, SoundID, 1));
		
	}

	public static SoundManager getResourceManager() {
		return resourceManager;
	}

	public static void setResourceManager(SoundManager resourceManager) {
		SoundManager.resourceManager = resourceManager;
	}

	
    public void unloadAll()
    {
    	mSoundPool.release();      
    }
}
